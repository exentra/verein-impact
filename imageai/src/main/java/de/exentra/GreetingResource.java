package de.exentra;

import com.azure.ai.formrecognizer.documentanalysis.DocumentAnalysisClient;
import com.azure.ai.formrecognizer.documentanalysis.DocumentAnalysisClientBuilder;
import com.azure.ai.formrecognizer.documentanalysis.models.AnalyzeResult;
import com.azure.ai.formrecognizer.documentanalysis.models.OperationResult;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.BinaryData;
import com.azure.core.util.polling.SyncPoller;
import org.jboss.resteasy.reactive.MultipartForm;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

@Path("/hello")
public class GreetingResource {
    // set `<your-endpoint>` and `<your-key>` variables with the values from the Azure portal
    private static final String endpoint = "https://codeimpact-exe-form.cognitiveservices.azure.com/";
    private static final String key = "MY_TOKEN";

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(String base64Image) {
        // create your `DocumentAnalysisClient` instance and `AzureKeyCredential` variable
        DocumentAnalysisClient client = new DocumentAnalysisClientBuilder()
                .credential(new AzureKeyCredential(key))
                .endpoint(endpoint)
                .buildClient();

        // sample document
        try (ByteArrayInputStream stream = new ByteArrayInputStream(Base64.getDecoder().decode(base64Image))) {
            String modelId = "prebuilt-invoice";
            SyncPoller<OperationResult, AnalyzeResult> analyzeDocumentPoller =
                    client.beginAnalyzeDocument(modelId, BinaryData.fromStream(stream));

            AnalyzeResult analyzeResult = analyzeDocumentPoller.getFinalResult();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //
        return "Hello from RESTEasy Reactive";
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("upload")
    public Response uploadImage(@MultipartForm MultipartBody multipartBody) { // create your `DocumentAnalysisClient` instance and `AzureKeyCredential` variable
        DocumentAnalysisClient client = new DocumentAnalysisClientBuilder()
                .credential(new AzureKeyCredential(key))
                .endpoint(endpoint)
                .buildClient();

        // sample document
        String modelId = "prebuilt-invoice";
        BinaryData data = BinaryData.fromStream(multipartBody.file);
        SyncPoller<OperationResult, AnalyzeResult> analyzeDocumentPoller =
                client.beginAnalyzeDocument(modelId, data);

        AnalyzeResult analyzeResult = analyzeDocumentPoller.getFinalResult();

        return Response.ok().build();

    }
}

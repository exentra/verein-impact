package Endpoint;

import Repository.InvoiceRepository;
import de.exentra.codeimpact.model.Invoice;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

public class InvoiceEndpoint {

    @Inject
    InvoiceRepository invoiceRepository;

    @GET
    @Path("/list")
    public List<Invoice> getList() {
        return invoiceRepository.listAll();
    }

    @POST
    @Path("/add")
    public Invoice addInvoice(Invoice invoice) {
        invoiceRepository.persist(invoice);
        return invoice;
    }
}

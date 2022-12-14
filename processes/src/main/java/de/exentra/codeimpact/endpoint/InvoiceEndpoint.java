package de.exentra.codeimpact.endpoint;

import de.exentra.codeimpact.repository.InvoiceRepository;
import de.exentra.codeimpact.model.Invoice;


import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/invoice")
public class InvoiceEndpoint {

    @Inject
    InvoiceRepository invoiceRepository;

    @GET
    @Path("/{id}")
    public Invoice getById(@PathParam("id") Long invoiceNumber) {
        return invoiceRepository.find(invoiceNumber);
    }

    @GET
    @Path("/list")
    public List<Invoice> getList() {
        return invoiceRepository.listAll();
    }

    @POST
    @Path("/add")
    @Transactional
    public Invoice addInvoice(Invoice invoice) {
        invoiceRepository.persist(invoice);
        return invoice;
    }
}

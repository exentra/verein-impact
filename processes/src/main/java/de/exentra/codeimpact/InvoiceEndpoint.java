package de.exentra.codeimpact;

import de.exentra.codeimpact.repository.InvoiceRepository;
import de.exentra.codeimpact.model.Invoice;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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

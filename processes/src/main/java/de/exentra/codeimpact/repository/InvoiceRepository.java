package de.exentra.codeimpact.repository;

import de.exentra.codeimpact.model.Invoice;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InvoiceRepository implements PanacheMongoRepository<Invoice> {

    private static final String FIND_BY_INVOICE_NUMBER_FORMAT = "{\"invoiceNumber\": %d}";

    public PanacheQuery<Invoice> findByInvoiceNumber(Long invoiceNumber){
        return find(String.format(FIND_BY_INVOICE_NUMBER_FORMAT, invoiceNumber));
    }

}

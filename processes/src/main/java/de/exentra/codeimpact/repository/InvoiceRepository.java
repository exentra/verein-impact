package de.exentra.codeimpact.repository;

import de.exentra.codeimpact.model.Invoice;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InvoiceRepository implements PanacheMongoRepository<Invoice> {
}

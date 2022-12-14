package de.exentra.codeimpact.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import de.exentra.codeimpact.model.Invoice;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class InvoiceRepository implements PanacheMongoRepository<Invoice> {

    private static final String INVOICE_NUMBER = "invoiceNumber";
    private static final String MATCH = "$match";
    private static final String TEXT = "$text";
    private static final String SEARCH = "$search";

    public FindIterable<Invoice> findByInvoiceNumber(Long invoiceNumber){
        return mongoCollection().find(new Document(INVOICE_NUMBER, invoiceNumber), Invoice.class);
    }

    public AggregateIterable<Invoice> fuzzySearch(String text){
        return mongoCollection().aggregate(aggregateTextSearch(text));
    }

    private List<Document> aggregateTextSearch(String text){
        return List.of(
                new Document(MATCH,
                        new Document(TEXT,
                                new Document(SEARCH, text))));
    }
}

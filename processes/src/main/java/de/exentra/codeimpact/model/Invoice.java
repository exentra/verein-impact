package de.exentra.codeimpact.model;

import io.quarkus.mongodb.panache.common.MongoEntity;

import java.time.LocalDateTime;
import java.util.Collection;

@MongoEntity(collection = "invoices")
public record Invoice(Long invoiceNumber, LocalDateTime date, String biller,
                      String customerId, String invoiceAddress, Double totalBruttoAmount,
                      Double totalNettoAmount, String description, Collection<InvoiceItem> invoiceItems) {}

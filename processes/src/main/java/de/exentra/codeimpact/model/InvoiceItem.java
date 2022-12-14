package de.exentra.codeimpact.model;

public record InvoiceItem(Long position, String description, Double count,
                          Double nettoPrice, Double bruttoPrice, Double tax) {}

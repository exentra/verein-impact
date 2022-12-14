package de.exentra.codeimpact.model;

import java.time.LocalDateTime;
import java.util.Collection;

public class Invoice {

    private Long invoiceNumber;

    private LocalDateTime date;

    private String biller;

    private String customerId;

    private String invoiceAddress;

    private Double totalBruttoAmount;

    private Double totalNettoAmount;

    private String description;

    private Collection<InvoiceItem> invoiceItems;

}

package de.exentra.entities;

import java.time.LocalDateTime;
import java.util.List;

class Invoice
{
    public int invoiceNumber;
    public LocalDateTime date;
    public String biller;
    public String invoiceAdddress;
    public double totalBruttoAmount;
    public double totalNettoAmount;
    public String description;
    public List<InvoiceItem> invoiceItems;

    public Invoice()
    {
    }

    public static class InvoiceItem
    {
        public String position;
        public String description;
        public double count;
        public double nettoPrice;
        public double bruttoPrice;
        public double tax;

        public InvoiceItem()
        {
        }
    }
}
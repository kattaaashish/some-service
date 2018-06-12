package com.java.database.invoice.store;

public interface IInvoiceStore {

	public boolean isInvoiceGenerated(String orderId);

	public String getInvoiceContent(String orderId);

	public boolean generateInvoice(String orderId);
}

package com.java.library.orders;

/*
 *This enum denotes all notification types which are sent in a order lifeline 
 */
public enum OrderNotificationType {
	GENERATED_WITHOUT_INVOICE(0), GENERATED_WITH_INVOICE(1), PICKED(2), DELIVERED(3);

	private OrderNotificationType(int order) {
		this.order = order;
	}

	int order;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}

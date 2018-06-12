package com.java.library.events;

import com.java.library.orders.OrderNotificationType;

public class OrderEvent implements IEvent {

	private String orderId;
	private String description;
	private int time;
	private OrderNotificationType orderNotificationType;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public OrderNotificationType getOrderNotificationType() {
		return orderNotificationType;
	}

	public void setOrderNotificationType(OrderNotificationType orderNotificationType) {
		this.orderNotificationType = orderNotificationType;
	}

}

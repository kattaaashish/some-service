package com.java.database.notification.store;

import com.java.library.notifications.NotificationType;
import com.java.library.orders.OrderNotificationType;

public interface IUserNotificationStore {

	/*
	 * this method pulls all notifications sent for a order Returns true if a
	 * notification has been sent for provided OrderNotificationType or higher
	 * order OrderNotificationType
	 */
	public boolean isNotificationSentForUserOrderType(String userId, String orderId,
			OrderNotificationType orderNotificationType, NotificationType notificationType);

	public boolean storeNotification(String orderId, String userId, NotificationType notificationType,
			OrderNotificationType orderNotificationType);
}

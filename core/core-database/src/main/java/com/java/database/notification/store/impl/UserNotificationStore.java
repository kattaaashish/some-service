package com.java.database.notification.store.impl;

import com.java.database.notification.store.IUserNotificationStore;
import com.java.library.notifications.NotificationType;
import com.java.library.orders.OrderNotificationType;

public class UserNotificationStore implements IUserNotificationStore {

	public UserNotificationStore() {

	}

	public boolean isNotificationSentForUserOrderType(String userId, String orderId,
			OrderNotificationType orderNotificationType, NotificationType notificationType) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean storeNotification(String orderId, String userId, NotificationType notificationType,
			OrderNotificationType orderNotificationType) {
		// TODO Auto-generated method stub
		return false;
	}

}

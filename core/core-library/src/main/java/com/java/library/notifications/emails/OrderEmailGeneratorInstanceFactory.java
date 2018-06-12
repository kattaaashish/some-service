package com.java.library.notifications.emails;

import com.java.library.notifications.emails.provider.IEmailProvider;
import com.java.library.notifications.strategy.IDeliverStrategy;
import com.java.library.orders.OrderNotificationType;

public class OrderEmailGeneratorInstanceFactory {

	public static Emailer getEmailGeneratorInstance(OrderNotificationType orderNotificationType,
			IDeliverStrategy deliverStrategy, IEmailProvider emailProvider) {
		switch (orderNotificationType) {
		case GENERATED_WITH_INVOICE:
			return new OrderCreatedEmailGenerator(deliverStrategy, emailProvider);
		}
		return null;

	}
}

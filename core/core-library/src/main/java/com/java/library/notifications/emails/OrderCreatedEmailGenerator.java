package com.java.library.notifications.emails;

import com.java.library.notifications.emails.provider.IEmailProvider;
import com.java.library.notifications.strategy.IDeliverStrategy;

public class OrderCreatedEmailGenerator extends Emailer {

	public OrderCreatedEmailGenerator(IDeliverStrategy deliverStrategy, IEmailProvider emailProvider) {
		super(deliverStrategy, emailProvider);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean generateAndSendEmail() {
		// TODO Auto-generated method stub
		return false;
	}

}

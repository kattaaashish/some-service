package com.java.library.notifications.emails;

import com.java.library.notifications.emails.provider.IEmailProvider;
import com.java.library.notifications.strategy.IDeliverStrategy;

public abstract class Emailer {

	private final IDeliverStrategy deliverStrategy;
	private final IEmailProvider emailProvider;

	public Emailer(IDeliverStrategy deliverStrategy, IEmailProvider emailProvider) {
		super();
		this.deliverStrategy = deliverStrategy;
		this.emailProvider = emailProvider;
	}

	public boolean generateAndSendEmail() {
		return false;
	}

}

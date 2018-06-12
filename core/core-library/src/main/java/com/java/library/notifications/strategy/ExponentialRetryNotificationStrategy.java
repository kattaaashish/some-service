package com.java.library.notifications.strategy;

import com.java.library.notifications.emails.EmailInfo;
import com.java.library.notifications.emails.provider.IEmailProvider;

public class ExponentialRetryNotificationStrategy implements IDeliverStrategy {

	private final IEmailProvider emailProvider;

	public ExponentialRetryNotificationStrategy(IEmailProvider emailProvider) {
		super();
		this.emailProvider = emailProvider;
	}

	public boolean sendEmail(EmailInfo emailInfo) {
		return false;
	}

}

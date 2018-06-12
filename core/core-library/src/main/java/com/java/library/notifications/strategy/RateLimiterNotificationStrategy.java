package com.java.library.notifications.strategy;

import com.java.library.notifications.emails.EmailInfo;
import com.java.library.notifications.emails.provider.IEmailProvider;

public class RateLimiterNotificationStrategy implements IDeliverStrategy {

	private final IEmailProvider emailProvider;

	public RateLimiterNotificationStrategy(IEmailProvider emailProvider) {
		this.emailProvider = emailProvider;
	}

	public boolean sendEmail(EmailInfo emailInfo) {
		// TODO Auto-generated method stub
		return false;
	}

}

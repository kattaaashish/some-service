package com.java.library.notifications.strategy;

import com.java.library.notifications.emails.EmailInfo;

public interface IDeliverStrategy {

	public boolean sendEmail(EmailInfo emailInfo);
}

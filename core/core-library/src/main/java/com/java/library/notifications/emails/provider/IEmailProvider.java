package com.java.library.notifications.emails.provider;

import com.java.library.notifications.emails.EmailInfo;

public interface IEmailProvider {

	public boolean sendEmail(EmailInfo emailInfo);

}

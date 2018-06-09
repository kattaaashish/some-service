package email_service.emails;

import messaging_service.messaging.IMessage;
import messaging_service.messaging.IQueue;
import messaging_service.messaging.object.OrderMessage;

public class EmailProcessTask implements Runnable {
	private final IQueue<OrderMessage> queue;

	public EmailProcessTask(IQueue<OrderMessage> queue) {
		this.queue = queue;
	}

	public void run() {
		while (true) {
			IMessage<OrderMessage> message = queue.receiveMessage();
			if (message != null) {
				try {
					/*
					 * 
					 * Do the processing of the message
					 * 
					 */} finally {
					queue.deleteMesage(message);
				}
			}
		}
	}
}

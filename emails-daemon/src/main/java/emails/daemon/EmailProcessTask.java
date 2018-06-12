package emails.daemon;

import com.java.database.invoice.store.IInvoiceStore;
import com.java.database.notification.store.IUserNotificationStore;
import com.java.library.events.OrderEvent;
import com.java.library.notifications.NotificationType;
import com.service.queue.IMessage;
import com.service.queue.IQueue;

public class EmailProcessTask implements Runnable {
	private final IQueue<OrderEvent> queue;
	private final IUserNotificationStore userNotificationStore;
	private final IInvoiceStore invoiceStore;

	public EmailProcessTask(IQueue<OrderEvent> queue, IUserNotificationStore userNotificationStore,
			IInvoiceStore invoiceStore) {
		this.queue = queue;
		this.userNotificationStore = userNotificationStore;
		this.invoiceStore = invoiceStore;
	}

	public void run() {
		while (true) {
			IMessage<OrderEvent> message = queue.receiveMessage();
			if (message != null) {
				OrderEvent orderEvent = message.getBody();
				try {
					if (userNotificationStore.isNotificationSentForUserOrderType(orderEvent.getUserId(),
							orderEvent.getOrderId(), orderEvent.getOrderNotificationType(), NotificationType.EMAIL)) {
						if (invoiceStore.isInvoiceGenerated(orderEvent.getOrderId())) {

						} else {

						}
					}

				} finally {
					queue.deleteMesage(message);
				}
			}
		}
	}
}

package invoice_generator.invoice;

import com.java.database.invoice.store.IInvoiceStore;

import messaging_service.messaging.IMessage;
import messaging_service.messaging.IQueue;
import messaging_service.messaging.object.OrderMessage;

public class InvoiceProcessorTask implements Runnable {

	private final IQueue<OrderMessage> queue;
	private final IInvoiceStore invoiceStore;
	private final IQueue<OrderMessage> emailerQueue;

	public InvoiceProcessorTask(IQueue<OrderMessage> queue, IInvoiceStore invoiceStore,
			IQueue<OrderMessage> emailerQueue) {
		this.queue = queue;
		this.invoiceStore = invoiceStore;
		this.emailerQueue = emailerQueue;
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
					 */
				} finally {
					queue.deleteMesage(message);
					emailerQueue.sendMessage(message);
				}

			}
		}
	}

}

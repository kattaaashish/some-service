package emails.daemon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.java.database.invoice.store.IInvoiceStore;
import com.java.database.invoice.store.impl.InvoiceStore;
import com.java.database.notification.store.IUserNotificationStore;
import com.java.database.notification.store.impl.UserNotificationStore;
import com.java.library.events.OrderEvent;
import com.service.queue.IQueue;
import com.service.queue.IQueueFactory;
import com.service.queue.impl.SQSQueueFactory;

public class EmailerProcess {

	private final ExecutorService executorService;
	private final IQueue<OrderEvent> queue;
	private final IUserNotificationStore userNotificationStore;
	private final IInvoiceStore invoiceStore;

	public EmailerProcess(int numOfThreads, IQueueFactory queueFactory, String queueName,
			IUserNotificationStore userNotificationStore, IInvoiceStore invoiceStore) {
		this.executorService = Executors.newFixedThreadPool(numOfThreads);
		IQueue<OrderEvent> queue = queueFactory.getQueue(queueName, OrderEvent.class);
		this.queue = queue;
		this.userNotificationStore = userNotificationStore;
		this.invoiceStore = invoiceStore;
	}

	private void runProcess() {
		EmailProcessTask emailProcessTask = new EmailProcessTask(queue, userNotificationStore,invoiceStore);
		executorService.submit(emailProcessTask);
	}

	public static void main(String[] args) {
		IQueueFactory queueFactory = new SQSQueueFactory();
		IUserNotificationStore userNotificationStore = new UserNotificationStore();
		IInvoiceStore invoiceStore = new InvoiceStore();
		EmailerProcess emailerProcess = new EmailerProcess(3, queueFactory, "emailProcessorQueue",
				userNotificationStore, invoiceStore);

		emailerProcess.runProcess();

	}

}

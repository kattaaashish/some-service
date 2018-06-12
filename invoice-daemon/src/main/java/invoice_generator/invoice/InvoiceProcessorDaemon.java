package invoice_generator.invoice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.java.database.invoice.store.IInvoiceStore;
import com.java.database.invoice.store.impl.InvoiceStore;

import messaging_service.messaging.IQueue;
import messaging_service.messaging.IQueueFactory;
import messaging_service.messaging.object.OrderMessage;
import messaging_service.messaging.sqs.impl.SQSQueueFactory;

public class InvoiceProcessorDaemon {

	private final ExecutorService executorService;
	private final IQueue<OrderMessage> queue;
	private final IInvoiceStore invoiceStore;
	private final IQueue<OrderMessage> emailerQueue;

	public InvoiceProcessorDaemon(int numOfThreads, IQueueFactory queueFactory, String queueName,
			IInvoiceStore invoiceStore, String emailQueueName) {
		this.executorService = Executors.newFixedThreadPool(numOfThreads);
		IQueue<OrderMessage> queue = queueFactory.getQueue(queueName, OrderMessage.class);
		this.queue = queue;
		this.emailerQueue = queueFactory.getQueue(emailQueueName, OrderMessage.class);
		this.invoiceStore = invoiceStore;
	}

	private void runProcess() {
		InvoiceProcessorTask invoiceProcessorTask = new InvoiceProcessorTask(queue, invoiceStore, emailerQueue);
		executorService.submit(invoiceProcessorTask);
	}

	public static void main(String[] args) {
		IQueueFactory queueFactory = new SQSQueueFactory();
		IInvoiceStore invoiceStore = new InvoiceStore();
		InvoiceProcessorDaemon invoiceProcessorDaemon = new InvoiceProcessorDaemon(3, queueFactory,
				"invoiceProcessorQueue", invoiceStore, "emailerQueue");
		invoiceProcessorDaemon.runProcess();

	}

}

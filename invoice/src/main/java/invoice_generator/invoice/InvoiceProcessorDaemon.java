package invoice_generator.invoice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import messaging_service.messaging.IQueue;
import messaging_service.messaging.IQueueFactory;
import messaging_service.messaging.object.OrderMessage;
import messaging_service.messaging.sqs.impl.SQSQueueFactory;

public class InvoiceProcessorDaemon {

	private final ExecutorService executorService;
	private final IQueue<OrderMessage> queue;

	public InvoiceProcessorDaemon(int numOfThreads, IQueueFactory queueFactory, String queueName) {
		this.executorService = Executors.newFixedThreadPool(numOfThreads);
		IQueue<OrderMessage> queue = queueFactory.getQueue(queueName, OrderMessage.class);
		this.queue = queue;
	}

	private void runProcess() {
		InvoiceProcessorTask invoiceProcessorTask = new InvoiceProcessorTask(queue);
		executorService.submit(invoiceProcessorTask);
	}

	public static void main(String[] args) {
		IQueueFactory queueFactory = new SQSQueueFactory();
		InvoiceProcessorDaemon invoiceProcessorDaemon = new InvoiceProcessorDaemon(3, queueFactory,
				"invoiceProcessorQueue");
		invoiceProcessorDaemon.runProcess();

	}

}

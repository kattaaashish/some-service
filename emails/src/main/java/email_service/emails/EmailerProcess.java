package email_service.emails;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import messaging_service.messaging.IQueue;
import messaging_service.messaging.IQueueFactory;
import messaging_service.messaging.object.OrderMessage;
import messaging_service.messaging.sqs.impl.SQSQueueFactory;

public class EmailerProcess {

	private final ExecutorService executorService;
	private final IQueue<OrderMessage> queue;

	public EmailerProcess(int numOfThreads, IQueueFactory queueFactory, String queueName) {
		this.executorService = Executors.newFixedThreadPool(numOfThreads);
		IQueue<OrderMessage> queue = queueFactory.getQueue(queueName, OrderMessage.class);
		this.queue = queue;
	}

	private void runProcess() {
		EmailProcessTask emailProcessTask = new EmailProcessTask(queue);
		executorService.submit(emailProcessTask);
	}

	public static void main(String[] args) {
		IQueueFactory queueFactory = new SQSQueueFactory();
		EmailerProcess emailerProcess = new EmailerProcess(3, queueFactory, "emailProcessorQueue");
		emailerProcess.runProcess();

	}

}

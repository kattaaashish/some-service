package messaging_service.messaging.sqs.impl;

import messaging_service.messaging.IQueue;
import messaging_service.messaging.IQueueFactory;

public class SQSQueueFactory implements IQueueFactory {

	/*
	 * get instance of sqs queue factory using aws credentials
	 */
	public SQSQueueFactory() {

	}

	public <T> IQueue<T> getQueue(String name, Class<T> klass) {
		SQSQueue<T> sqsQueue = new SQSQueue<T>(name);
		return sqsQueue;

	}

}

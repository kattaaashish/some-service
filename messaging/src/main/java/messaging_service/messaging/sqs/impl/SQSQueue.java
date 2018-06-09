package messaging_service.messaging.sqs.impl;

import messaging_service.messaging.IMessage;
import messaging_service.messaging.IQueue;

public class SQSQueue<T> implements IQueue<T> {

	public SQSQueue(String name) {
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void sendMessage(IMessage<T> msg) {
		// TODO Auto-generated method stub

	}

	public IMessage<T> receiveMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteMesage(IMessage<T> msg) {
		// TODO Auto-generated method stub

	}

}

package com.service.queue;

public interface IQueue<T> {
	public String getName();

	public void sendMessage(IMessage<T> msg);

	public IMessage<T> receiveMessage();

	public void deleteMesage(IMessage<T> msg);
}

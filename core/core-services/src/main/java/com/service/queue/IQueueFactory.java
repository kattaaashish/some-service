package com.service.queue;

public interface IQueueFactory {

	<T> IQueue<T> getQueue(String name, Class<T> klass);
}

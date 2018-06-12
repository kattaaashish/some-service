package com.service.queue;

public interface IMessage<T> {
	String getId();

	T getBody();

	void setBody(T body);

}

package messaging_service.messaging;

public interface IMessage<T> {
	String getId();

	T getBody();

	void setBody(T body);

}

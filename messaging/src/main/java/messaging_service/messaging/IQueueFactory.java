package messaging_service.messaging;

public interface IQueueFactory {

	<T> IQueue<T> getQueue(String name, Class<T> klass);
}

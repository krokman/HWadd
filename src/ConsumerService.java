public interface ConsumerService<T> {
	String getFrom();

	String getTo();

	T getContent();
}

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<ConsumerService<T>> {
	private Map<String, List<T>> mailBox;

	public MailService() {
		mailBox = new HashMap<String, List<T>>() {
			@Override
			public List<T> get(Object key) {
				return super.getOrDefault(key, new LinkedList<>());
			}
		};
	}

	public Map<String, List<T>> getMailBox() {
		return mailBox;
	}

	@Override
	public void accept(ConsumerService<T> consumerService) {
		List<T> list = mailBox.get(consumerService.getTo());
		list.add(consumerService.getContent());
		mailBox.put(consumerService.getTo(), list);
	}
}

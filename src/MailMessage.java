public class MailMessage extends ConsumerService<String> {
	public MailMessage(String from, String to, String content) {
		super(from, to, content);
	}
}
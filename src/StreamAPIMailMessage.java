import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StreamAPIMailMessage {
	public static void main(String[] args) {
		// Random variables
		String randomFrom = "..."; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
		String randomTo = "...";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
		int randomSalary = 100;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.

		// Создание списка из трех почтовых сообщений.
		MailMessage firstMessage = new MailMessage(
				"Robert Howard",
				"H.P. Lovecraft",
				"This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
		);

		assert firstMessage.getFrom().equals("Robert Howard") : "Wrong firstMessage from address";

		assert firstMessage.getTo().equals("H.P. Lovecraft") : "Wrong firstMessage to address";

		assert firstMessage.getContent().endsWith("Howard!") : "Wrong firstMessage content ending";

		MailMessage secondMessage = new MailMessage(
				"Jonathan Nolan",
				"Christopher Nolan",
				"Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
		);

		MailMessage thirdMessage = new MailMessage(
				"Stephen Hawking",
				"Christopher Nolan",
				"Я так и не понял Интерстеллар."
		);

		List<MailMessage> messages = Arrays.asList(firstMessage, secondMessage, thirdMessage);

		// Создание почтового сервиса.
		MailService<String> mailService = new MailService<>();

		// Обработка списка писем почтовым сервисом
		messages.stream().forEachOrdered(mailService);

		// Получение и проверка словаря "почтового ящика",
		// где по получателю можно получить список сообщений, которые были ему отправлены
		Map<String, List<String>> mailBox = mailService.getMailBox();

		assert mailBox.get("H.P. Lovecraft").equals(Arrays.asList(
				"This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
		)) : "wrong mailService mailbox content (1)";

		assert mailBox.get("Christopher Nolan").equals(Arrays.asList(
				"Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!",
				"Я так и не понял Интерстеллар.")) : "wrong mailService mailbox content (2)";

		assert mailBox.get(randomTo).equals(Collections.<String>emptyList()) : "wrong mailService mailbox content (3)";
	}
}

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StreamAPISalary {
	public static void main(String[] args) {
		// Random variables
		String randomFrom = "..."; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
		String randomTo = "...";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
		int randomSalary = 100;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.


		// Создание списка из трех зарплат.
		Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
		Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
		Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

		// Создание почтового сервиса, обрабатывающего зарплаты.
		MailService<Integer> salaryService = new MailService<>();

		// Обработка списка зарплат почтовым сервисом
		Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

		// Получение и проверка словаря "почтового ящика",
		// где по получателю можно получить список зарплат, которые были ему отправлены.
		Map<String, List<Integer>> salaries = salaryService.getMailBox();

		assert salaries.get(salary1.getTo()).equals(Arrays.asList(1)) : "wrong salaries mailbox content (1)";

		assert salaries.get(salary2.getTo()).equals(Arrays.asList(Integer.MAX_VALUE)) : "wrong salaries mailbox content (2)";

		assert salaries.get(randomTo).equals(Arrays.asList(randomSalary)) : "wrong salaries mailbox content (3)";
	}
}

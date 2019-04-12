import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinMax {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 5));
		findMinMax(list.stream(), Integer::compareTo, (o1, o2) -> System.out.println("min = " + o1 + " " + "max = " + o2));
	}

	public static <T> void findMinMax(
			Stream<? extends T> stream,
			Comparator<? super T> order,
			BiConsumer<? super T, ? super T> minMaxConsumer) {

		LinkedList<T> list = new LinkedList<>(stream.sorted(order).collect(Collectors.toList()));
		if (list.isEmpty()) {
			minMaxConsumer.accept(null, null);
		} else {
			minMaxConsumer.accept(list.getFirst(), list.getLast());
		}
	}
}

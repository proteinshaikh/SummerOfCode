package CoreJava;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SplitIterator {

	public static <T> Stream<T> iteratorToSequentialStream(Iterator<T> itr) {
		Spliterator<T> spitr = Spliterators.spliteratorUnknownSize(itr, Spliterator.NONNULL);

		return StreamSupport.stream(spitr, false);
	}
	
	public static void main(String[] srgs) {
		Iterator<String> iterator = Arrays.asList("Z","E","E","S").iterator();
		
		Stream<String> stream = iteratorToSequentialStream(iterator);
		System.out.println("sequential stream : " + stream.collect(Collectors.toList()));
	}

}

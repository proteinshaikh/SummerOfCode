package Java8;

import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.forEach(x -> System.out.print(x + ", "));

    }
}

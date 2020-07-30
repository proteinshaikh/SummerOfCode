package Java_8;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOf {
    public static void main(String[] args) {

        System.out.println(Stream.of(1, 2, 3, 4, 5, 6).reduce(0, Integer::sum));

        //Arrays to stream
        //find max number in array

        int[] numArray = {1, 2, 3, 4, 5, 6};

        System.out.println(Arrays.stream(numArray).max());
        System.out.println(Arrays.stream(numArray).min());
        System.out.println(Arrays.stream(numArray).sum());

        //generate stream
        System.out.println(IntStream.range(1, 10).sum());

        System.out.println(IntStream.rangeClosed(1, 10).sum());

        //infinite stream with limit
        System.out.println(IntStream.iterate(1, e -> e + 2).limit(10).sum());

        System.out.println(IntStream.iterate(1, e -> e + 2).limit(10).peek(System.out::println).sum());

        //print all even number sums
        System.out.println(IntStream.iterate(2, e -> e + 2).limit(10).peek(System.out::println).sum());

        //sum of num*2
        System.out.println(IntStream.iterate(2, e -> e * 2).limit(10).peek(System.out::println).sum());

        //convert to list using Boxed
        System.out.println(IntStream.iterate(2, e -> e * 2).limit(10).boxed().collect(Collectors.toList()));

    }
}

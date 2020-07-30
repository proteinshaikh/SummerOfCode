package Java_8;

import java.util.Arrays;
import java.util.List;

public class Filter {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        printEvenNumbers(list);

    }

    private static void printEvenNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(num -> num%2 == 0 )
                .forEach(System.out::println);
    }
}

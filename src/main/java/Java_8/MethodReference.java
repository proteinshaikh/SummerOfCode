package Java_8;

import java.util.Arrays;
import java.util.List;

public class MethodReference {
    public static void main(String[] args) {
        printNumbersInListFunctional(Arrays.asList(2,3,5,12,10,9));
    }


    private static void printNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .forEach(System.out::println);
    }
}

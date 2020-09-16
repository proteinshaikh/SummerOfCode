package Java8;

import java.util.Arrays;
import java.util.List;

public class Maps {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream()
                .filter(nums -> nums % 2 == 0)
                .map(num -> num * num)
                .forEach(System.out::println);
    }
}

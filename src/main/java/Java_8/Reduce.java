package Java_8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sums = list.stream()
                .filter(num -> num % 2 != 0)
                .reduce(0, Integer::sum);
        System.out.println("Sum of List of Numbers = " + sums);

        int squareOfList = list.stream().map(x -> x * x).reduce(0, Integer::sum);
        System.out.println("Sum of Square of numbers = " + squareOfList);


        int cubeOfList = list.stream().map(x -> x * x * x).reduce(0, Integer::sum);
        System.out.println("Sum of Cube of numbers = " + cubeOfList);

        System.out.println(list.stream().map(x -> x * x).collect(Collectors.toList()));

        List<String> strings = Arrays.asList("Zeeshan Shaikh", "Akram Shaikh", "Razia Shaikh");

        System.out.println((strings.stream().filter(w -> w.contains("Zeeshan")).collect(Collectors.toList())) + " This is cool");

        List<Integer> in = Arrays.asList(1, 3, 5, 4, 2);
        System.out.println("addition of even nos are = " + (String.valueOf(in.stream().filter(e -> e % 2 == 0).reduce(0, Integer::sum))));
    }
}

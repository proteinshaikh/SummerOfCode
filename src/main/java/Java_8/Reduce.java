package Java_8;

import java.util.Arrays;
import java.util.List;

public class Reduce {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sums = list.stream()
                .filter(num -> num % 2 != 0)
                .reduce(0, Integer::sum);
        System.out.println("Sum of List of Numbers = "+sums);

        int squareOfList = list.stream().map(x -> x*x).reduce(0,Integer::sum);
        System.out.println("Sum of Square of numbers = " +squareOfList);


        int cubeOfList = list.stream().map(x -> x*x*x).reduce(0,Integer::sum);
        System.out.println("Sum of Cube of numbers = " +cubeOfList);


    }
}

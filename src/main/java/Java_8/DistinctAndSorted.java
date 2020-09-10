package Java_8;

import java.util.Arrays;
import java.util.List;

public class DistinctAndSorted {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6, 45, 3, 55, 90, 2, 10, 7, 98);
        List<String> str = Arrays.asList("Apple", "Microsoft", "Zeta", "Amazon", "Google", "Facebook");
        //distinct

        list.stream().distinct().sorted().forEach(System.out::println);

        str.stream().sorted().forEach(System.out::println);
    }
}

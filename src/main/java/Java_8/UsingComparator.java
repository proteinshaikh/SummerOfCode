package Java_8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class UsingComparator {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("Apple","Microsoft","Zeta", "Amazon", "Google", "Facebook");

        //natural order sort 1
        str.stream().distinct().sorted().forEach(System.out::println);

        //natural order sort 2
        //str.stream().distinct().sorted(Comparator.naturalOrder()).forEach(System.out::println);

        //reverse sort 1
        str.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //reverse sort 2
        str.stream().distinct().sorted(Comparator.comparing(x -> x.length())).forEach(System.out::println);
    }
}

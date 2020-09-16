package Java8;

import java.util.Arrays;
import java.util.List;

public class FilterContains {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Spring", "Spring Boot", "Spring Batch", "Azure");

        list.stream()
                .filter(words -> words.contains("Spring"))
                .forEach(System.out::println);
    }
}

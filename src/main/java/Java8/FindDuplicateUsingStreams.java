package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateUsingStreams {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(4, 3, 8, 6, 4, 6, 6, 7, 3, 4, 4);
        List<String> strList = Arrays.asList("bob", "bob", "dan", "dan", "rob");

        Map<Integer, Long> output = numList.stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        output.forEach((key, value) ->
                System.out.println(key + " " + value));

        Map<String, Long> output2 = strList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        output2.forEach((key, value) ->
                System.out.println(key + " " + value));
    }
}

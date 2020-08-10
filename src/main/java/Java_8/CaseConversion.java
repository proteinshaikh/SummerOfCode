package Java_8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CaseConversion {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("Apple","Microsoft","Zeta", "Amazon", "Google", "Facebook");


        //type 1
        str.stream().map(String::toUpperCase).forEach(System.out::println);


        //type 2: storing in list
        List<String> resString = str.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(resString);

    }
}

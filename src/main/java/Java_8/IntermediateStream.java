package Java_8;

import java.util.Arrays;
import java.util.List;

public class IntermediateStream {

    public static void main(String[] args) {

        List<String> courses = Arrays.asList("Spring", "Spring Boot", "Docker", "Zuul");

        System.out.println(
                courses.stream()
                        .filter(course -> course.length() > 5)
                        .map(String::toUpperCase)
                        .findFirst());

        System.out.println(
                courses.stream()
                        .peek(System.out::println)
                        .filter(course -> course.length() > 5)
                        .map(String::toUpperCase)
                        .peek(System.out::println)
                        .findFirst()
        );
    }
}

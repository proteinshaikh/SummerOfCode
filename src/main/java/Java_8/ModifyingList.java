package Java_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ModifyingList {
    public static void main(String[] args) {
        List<String> courses = Arrays.asList("Apple", "Microsoft", "Zeta", "Amazon", "Google", "Facebook");
        List<String> modifyableCourses = new ArrayList<>(courses);
        System.out.println(modifyableCourses);
        System.out.println(modifyableCourses.stream().map(str -> str.toUpperCase()).collect(Collectors.toList()));
        System.out.println(modifyableCourses.removeIf(str -> str.length() < 6));
    }
}

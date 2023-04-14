package Winter2022.h;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        for (String str : removeDuplicates(Arrays.asList("test", "test", "one", "two", "two"))) {
            System.out.print(str + " ");
        }
    }

    static List<String> removeDuplicates(List<String> strings) {
        return strings.stream().distinct().collect(Collectors.toList());
    }
}

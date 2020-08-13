package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//find 2nd highest number in array
public class SecondHighestNumberInArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,5,2,3,6,8);
        list = list.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("2nd gighest number = " +list.get(1));

    }
}

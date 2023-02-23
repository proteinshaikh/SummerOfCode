package Winter2022;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class MaxValue {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(maxNum(list));
    }

    static int maxNum(List<Integer> list) {
        return list.stream().mapToInt(i -> i).max().orElseThrow(NoSuchElementException::new);
    }
}

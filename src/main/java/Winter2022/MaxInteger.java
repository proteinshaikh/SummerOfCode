package Winter2022;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class MaxInteger {
    public static void main(String[] args) {
        System.out.println(getmaxnum(Arrays.asList(2323, 5654, 23, 6865, 344, 8, 2468, 2)));

    }

    static int getmaxnum(List<Integer> list) {
        return list.stream().mapToInt(x -> x).max().orElseThrow(NoSuchElementException::new);
    }
}

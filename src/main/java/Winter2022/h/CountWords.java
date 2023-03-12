package Winter2022.h;

import java.util.Arrays;

public class CountWords {
    public static void main(String[] args) {
        String str = "sample count words using streams streams";
        long count = Arrays.stream(str.split("\\s+"))
                .count();
        System.out.println("number of words in string = " + count);
    }
}

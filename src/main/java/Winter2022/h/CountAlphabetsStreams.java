package Winter2022.h;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//count the number of occurrences of each alphabet in a sentence using streams
public class CountAlphabetsStreams {

    public static void main(String[] args) {
        String str = "this is sample string to count number of letters in a senetnce";

        Map<Character, Long> map = str.chars()
                .filter(Character::isLetter)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);
    }
}

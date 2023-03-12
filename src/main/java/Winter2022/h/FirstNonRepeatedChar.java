package Winter2022.h;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedChar {
    public static void main(String[] args) {
        System.out.println(getFirstNonRepeatedChar("hello world"));
    }

    static char getFirstNonRepeatedChar(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        for (char c : str.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '\0';
    }
}

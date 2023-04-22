package Winter2022.i;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedChar {
    public static void main(String[] args) {
        System.out.println(getFirstNonRepeatedChar("zeeshan shaikh"));
    }

    static char getFirstNonRepeatedChar(String s) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (char c : charCount.keySet()) {
            if (charCount.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }
}


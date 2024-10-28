package winter2024;

import java.util.LinkedHashMap;
import java.util.Map;

public class CompressStringUsingMap {
    public static void main(String[] args) {
        String compressedString = compressString("aabbcccaabbcd");
        System.out.println(compressedString);
    }

    static String compressString(String str) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        str.chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> charCountMap.merge(c, 1, Integer::sum));

        StringBuilder result = new StringBuilder();
        charCountMap.forEach((k, v) -> result.append(k).append(v));

        return result.toString();
    }
}


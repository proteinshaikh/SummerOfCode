package Winter2022.d;

import java.util.HashMap;
import java.util.Map;

public class CompressStringUsingMap {
    public static void main(String[] args) {

        Map<Character, Integer> res = getCompressedString("aabbcccaabbcd");
        for (Map.Entry<Character, Integer> m : res.entrySet()) {
            System.out.print(m.getKey().toString() + m.getValue());
        }
    }

    static Map<Character, Integer> getCompressedString(String str) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        return map;
    }
}

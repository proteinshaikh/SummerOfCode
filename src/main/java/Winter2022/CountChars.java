package Winter2022;

import java.util.HashMap;
import java.util.Map;

public class CountChars {


    public static void main(String[] args) {
        String str = "Zeeshan Shaikh";
        Map<Character, Integer> map = getCount(str);
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            System.out.println(m.getKey().toString() + " : " + m.getValue());
        }

    }

    static Map<Character, Integer> getCount(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        return map;
    }
}

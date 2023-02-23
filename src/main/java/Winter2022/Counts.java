package Winter2022;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Counts {
    /*
    * How do you get distinct characters and their count in a string in Java?
 String str1 = "abcdABCDabcd";
 a=2, A=1, b=2, B=1, c=2, C=1, d=2, D=1
    * */
    public static void main(String[] args) {
        System.out.println(getcounts("zeeshan"));
    }


    static Map<Character, Integer> getcounts(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (map.containsKey(chars[i])) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}

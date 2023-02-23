package Winter2022;

import java.util.HashMap;
import java.util.Map;

public class CountCharacters {
    public static void main(String[] args) {
        String str = "committee for Indian cricket team";
        System.out.println(getReverseString(str));
        countOccurances(str);
        //reverse string
        //no occurances of each character in string
    }

    static char[] getReverseString(String str) {
        char chars[] = str.toCharArray();
        int len = chars.length;
        char tempchar[] = new char[len];
        for (int i = 0; i < len; i++) {
            tempchar[i] = chars[len - i - 1];
        }
        return tempchar;
    }

    static void countOccurances(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        char chars[] = str.toCharArray();

        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
    /*
    * The program creates a HashMap to store the count of each character.
    * It iterates through each character of the string and for each character, it checks if the character already present in the HashMap.
    * If the character is already present, it increments its count by 1.
    * If the character is not present in the HashMap, it adds the character to the HashMap with a count of 1.
    * Finally, it prints the count for each character.
    * */
}

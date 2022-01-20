package problems;

import java.util.*;

public class CountOccurancesOfEachWord {
    public static void main(String[] args) {
        countOccurances();

    }

    static void countOccurances() {
        String string = "I am Zeeshan Akram Shaikh. I live in Pune";


        char[] chars = string.toCharArray();
        List<Character> characters = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            int counter = 1;
            for (int j = 0; j < chars.length; j++) {
                for (int k = 0; k < characters.size(); k++) {
                    char find = characters.get(i);
                    if (find != temp && chars[j] == temp) {
                        counter++;
                    }
                }
                characters.add(temp);
                map.put(temp, counter);

            }
        }
        System.out.println(map.toString());
    }
}

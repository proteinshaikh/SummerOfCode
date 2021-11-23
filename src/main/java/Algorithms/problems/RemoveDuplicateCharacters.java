package Algorithms.problems;

import java.util.*;

public class RemoveDuplicateCharacters {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(Arrays.asList('a', 'a', 'b', 'c', 'c', 'c', 'd')));

    }

    static Set removeDuplicates(List<Character> charList) {
        int i = 0;
        Set<Character> characterSet = new HashSet<>();
        while (i < charList.size()) {
            characterSet.add(charList.get(i));
            i++;
        }
        return characterSet;
    }
}

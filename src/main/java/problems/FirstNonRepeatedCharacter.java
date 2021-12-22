package problems;

import java.util.Arrays;
import java.util.List;

public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        System.out.println("first non repeating character is: " + getFirstNonRepeatedCharacter("twitter"));

    }

    static char getFirstNonRepeatedCharacter(String input) {
        char temp = 0;
        int counter = 0;

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                temp = input.charAt(i);
                if (temp == input.charAt(j)) {
                    counter++;
                    if (counter > 1) {
                        counter = 0;
                        break;
                    }
                }
            }
            if (counter == 1) {
                break;
            }
        }
        return temp;
    }
}

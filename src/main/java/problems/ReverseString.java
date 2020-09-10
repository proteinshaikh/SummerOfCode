package problems;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        String string = "zeeshan";
        char[] chars = string.toCharArray();
        char temp;
        int strlen = string.length() - 1;
        for (int i = 0; i <= strlen; i++) {
            temp = string.charAt(i);
            chars[strlen - i] = temp;
        }
        System.out.println(chars);
    }
}

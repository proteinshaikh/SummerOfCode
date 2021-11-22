package Algorithms.problems;

public class StringPlay {
    public static void main(String[] args) {
        System.out.println(test("zEesHaN"));

    }

    static String test(String input) {
        int length = input.length();

        if (length % 2 == 0) {
            return input.toUpperCase();
        } else {
            return input.toLowerCase();
        }
    }
}

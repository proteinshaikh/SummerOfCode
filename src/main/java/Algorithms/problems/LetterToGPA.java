package Algorithms.problems;

public class LetterToGPA {
    public static void main(String[] args) {
        System.out.println(letterToGPA("A+"));

    }

    static double letterToGPA(String gpaPoint) {

        return switch (gpaPoint) {
            case "A+", "A" -> 4;
            case "A-" -> 3.7;
            default -> -1;
        };
    }
}

package Algorithms.problems;

public class LetterToGPA {
    public static void main(String[] args) {
        System.out.println(letterToGPA("A+"));

    }

    static double letterToGPA(String gpaPoint) {
        double answer;

        switch (gpaPoint) {
            case "A+":
                answer = 4;
                break;

            case "A":
                answer = 4;
                break;

            case "A-":
                answer = 3.7;
                break;

            default:
                answer = -1;
                break;
        }
        return answer;
    }
}

package problems;

/*
Input is a string like "AAAAABBCCAA" and it should print "5A2B2C2A". 5 being the continuous number of occurance
 for character 'A'. Same is with other characters also.
 */

public class CountCharacters {
    public static void main(String[] args) {
        String input = "AAAAABBCCAA";
        char[] charinput = input.toCharArray();
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int temp = 0;
        for (int i = 0; i < charinput.length; i++) {
            if (charinput[i] == 'A') {
                countA++;
                temp += countA;
                countA=0;

            } else if (charinput[i] == 'B') {
                System.out.print(temp);
                temp=0;
                countB++;
            } else {
                countC++;
            }

        }
        System.out.println("A" + countB + "B" + countC + "C" + temp + "A");
    }
}

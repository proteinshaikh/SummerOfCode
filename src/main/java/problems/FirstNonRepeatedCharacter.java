package problems;

public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        System.out.println("first non repeating character is: " + getFirstNonRepeatedCharacter("twitter"));
        System.out.println(tesTryCatchFinally());

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

    static String tesTryCatchFinally() {
        String zee = null;
        try {
            zee = "zeeshan";
        } catch (Exception e) {
            return "exception";
        } finally {
            return zee;
        }
    }
}

package Winter2022;

public class CompressString {
    public static String compressString(String input) {
        StringBuilder compressedString = new StringBuilder();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count++;
            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                compressedString.append(input.charAt(i));
                compressedString.append(count);
                count = 0;
            }
        }
        return compressedString.toString();
    }

    public static void main(String[] args) {
        String input = "aaabbccccd";
        System.out.println(compressString(input)); // a3b2c4d

    }

}


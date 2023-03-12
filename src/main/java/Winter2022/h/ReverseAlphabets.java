package Winter2022.h;

public class ReverseAlphabets {
    public static void main(String[] args) {
        System.out.println(getReversedAlphabets("this is test string"));
    }

    static String getReversedAlphabets(String str) {
        String[] strings = str.split("\\s+");
        StringBuilder resultBuilder = new StringBuilder();

        for (String s : strings) {
            StringBuilder reverseBuilder = new StringBuilder();

            for (int i = s.length() - 1; i >= 0; i--) {
                reverseBuilder.append(s.charAt(i));
            }

            String reverseWord = reverseBuilder.toString();
            resultBuilder.append(reverseWord);
            resultBuilder.append("  ");
        }

        String resultString = resultBuilder.toString().trim();
        return resultString;
    }
}

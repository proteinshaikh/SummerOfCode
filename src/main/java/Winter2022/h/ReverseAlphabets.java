package Winter2022.h;

/*write a java code to reverse the alphabets in a sentence without reversing the sequence of words*/
public class ReverseAlphabets {
    public static void main(String[] args) {
        System.out.println(getReversedAlphabets("john doe test"));
    }

    static String getReversedAlphabets(String str) {
        String[] strings = str.split("\\s+"); // 1
        StringBuilder resultBuilder = new StringBuilder();

        for (String s : strings) { //2.1
            StringBuilder reverseBuilder = new StringBuilder();

            for (int i = s.length() - 1; i >= 0; i--) { //2.2
                reverseBuilder.append(s.charAt(i));
            }

            String reverseWord = reverseBuilder.toString();
            resultBuilder.append(reverseWord);
            resultBuilder.append("  ");
        }

        return resultBuilder.toString().trim();
    }
}

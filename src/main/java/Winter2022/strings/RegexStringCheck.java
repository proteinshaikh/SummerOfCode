package Winter2022.strings;

import java.util.regex.Pattern;

public class RegexStringCheck {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        String strnum = "123.00";
        System.out.println(pattern.matcher(strnum).matches());
    }
}

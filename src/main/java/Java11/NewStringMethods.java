package Java11;

import java.util.List;
import java.util.stream.Collectors;

public class NewStringMethods {
    public static void main(String[] args) {
        String multilineString = "Zeeshan helps \n \\ developers \n explore Java.";
        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());
        assert lines.contains("test");
    }
}

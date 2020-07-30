package Java_8;


import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

//Java 9
import static java.nio.file.Files.lines;

public class Files {
    public static void main(String[] args) throws IOException {

        lines(Paths.get("sample.txt"))
                .map(str->str.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);

    }
}

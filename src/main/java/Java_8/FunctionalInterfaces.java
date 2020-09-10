package Java_8;

import sun.invoke.empty.Empty;

import java.util.Optional;
import java.util.function.Consumer;

public class FunctionalInterfaces {
    //optional

    public static void main(String[] args) {
        String[] str = new String[5];

        Optional<String> checkNull = Optional.ofNullable(str[1]);
        if (checkNull.isPresent()) {
            String string = str[2].toLowerCase();
            System.out.println(string);
        } else {
            System.out.println(" String is null");
        }

    }

}

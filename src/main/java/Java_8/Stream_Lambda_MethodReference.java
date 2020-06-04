package Java_8;

import java.util.ArrayList;
import java.util.List;

public class Stream_Lambda_MethodReference {

    public static void main(String[] args) {

            List<String> list=new ArrayList<String>();
            list.add("Zeeshan 1");
            list.add("Zeeshan 2");
            list.add("Zeeshan 3");

            list.stream()
                    .map(String::toLowerCase)
                    .map(String::toUpperCase)
                    .forEach(System.out::println);
        }
    }


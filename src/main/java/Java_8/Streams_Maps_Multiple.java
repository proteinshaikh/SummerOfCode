package Java_8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Streams_Maps_Multiple {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        list.add("Zeeshan 1");
        list.add("Zeeshan 2");
        list.add("Zeeshan 3");

        list.stream()
                .map((String element) -> {

                    String str= element.toLowerCase();
                    System.out.println("to lower case :  " +str);
                    return str;

                })
                .map((String element) -> {
                    String str2= element.toUpperCase();
                    System.out.println("to upper case :  " +str2);
                    return str2;
                })
                .forEach((String element) -> {
                    System.out.println("Final result : "+element);
                });
    }

}

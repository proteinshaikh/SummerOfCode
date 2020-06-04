package Java_8;

import java.util.ArrayList;
import java.util.List;

public class Compact_Stream {

    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        list.add("Zeeshan 1");
        list.add("Zeeshan 2");
        list.add("Zeeshan 3");

        list.stream()
                .map(ele -> ele.toLowerCase())
                .map(ele -> ele.toUpperCase())
                .forEach(ele -> System.out.println(ele));
    }
}

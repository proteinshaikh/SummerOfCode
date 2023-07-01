package Winter2022.h;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalEmptyList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();


        // Using Optional with an empty list
        System.out.println("Optional List = " + Optional.of(list));


        // Accessing elements of the Optional list
        List<String> mylist = Optional.of(list).orElse(null);


        // Adding elements to the Optional list
        mylist.add("zee");
        mylist.add("sha");

        System.out.println("updated list : " + mylist);
    }
}

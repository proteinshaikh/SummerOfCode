package CoreJava;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExp {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(list.toString() + " size: " + list.size());

        List<Integer> list1 = new ArrayList<>(list);
        System.out.println(list1.toString() + " size: " + list1.size());

    }
}

package CoreJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MissingNumber {
    public static void main(String[] args) {
        int arr[] = {0,1, 2, 3, 5};


        List<Integer> list = new ArrayList<Integer>();
        for (int nums : arr) {
            list.add(nums);
        }
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != i) {
                System.out.println(i + " is missing");
            }

        }
    }
}


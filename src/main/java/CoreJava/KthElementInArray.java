package CoreJava;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthElementInArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 10, 4, 3, 20, 15);
        System.out.println(getSamllest(list, 3));
        System.out.println(getLargest(list, 3));

    }

    //k smallest and largest element in unsorted integer array
    // {7,10,4,3,20,15}
    //smallest k=3 o/p 7
    //largest k=2 15
    static int getSamllest(List<Integer> list, int kthElement) {

        Collections.sort(list);
        return list.get(kthElement - 1);
    }

    static int getLargest(List<Integer> list, int kthElement) {

        Collections.sort(list);
        int len = list.size();//6
        return list.get(len - kthElement);
    }
}

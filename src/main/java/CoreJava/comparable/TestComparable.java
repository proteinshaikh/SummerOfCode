package CoreJava.comparable;

import java.util.ArrayList;
import java.util.Collections;

public class TestComparable {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new PlayerComparableSample("Zeeshan", 1));
        list.add(new PlayerComparableSample("Shaikh", 4));
        list.add(new PlayerComparableSample("Shaikh", 5));
        list.add(new PlayerComparableSample("Shaikh", 2));
        list.add(new PlayerComparableSample("Shaikh", 3));
        Collections.sort(list);

        System.out.println(list);
    }
}

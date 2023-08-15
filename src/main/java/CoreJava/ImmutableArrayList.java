package CoreJava;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImmutableArrayList {
    public static void main(String[] args) {
        testImmutableArraylist();

    }

    static void testImmutableArraylist() {
        List<String> list = Arrays.asList("Zeeshan", "Akram", "Shaikh");
        System.out.println(list.toString());

        System.out.println("Adding elemts in immutable arraylist...");

        List<String> immutableList = Collections.unmodifiableList(list);
        try {
            list.add("Test");
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException caught while adding elements in arraylist!");
        } catch (Exception ex) {
            System.out.println("Exception Caught : " + ex);
        }

    }
}

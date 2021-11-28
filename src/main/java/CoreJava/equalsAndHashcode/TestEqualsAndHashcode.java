package CoreJava.equalsAndHashcode;

import java.util.ArrayList;
import java.util.List;

public class TestEqualsAndHashcode {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Zeeshan", 1, 1));
        students.add(new Student("Zeeshan", 1, 1));

        if (students.get(0).hashCode() == students.get(1).hashCode()) {
            System.out.println("hashcodes are equal");
        } else {
            System.out.println("hashcodes are NOT equal");
        }

        System.out.println(students.size());
        System.out.println("students contains :" + students.contains(new Student("Zeeshan", 1, 1)));

    }
}

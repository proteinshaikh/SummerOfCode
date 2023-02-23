package Winter2022.comparator3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestComparator {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("zee", 1));
        students.add(new Student("sha", 2));
        students.add(new Student("akr", 3));

        System.out.println("sorting using id comparator");
        Collections.sort(students, new StudentIdComparator());
        for (Student student : students) {
            System.out.println("name: " + student.getName() + " id: " + student.getId());
        }

        Collections.sort(students, new StudentNameComparator());
        System.out.println("sorting using name comparator");
        for (Student student : students) {
            System.out.println("name: " + student.getName() + " id: " + student.getId());
        }
    }
}

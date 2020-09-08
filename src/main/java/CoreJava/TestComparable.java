package CoreJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {

    String name;
    int rollno;

    public Student(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }

    @Override
    public int compareTo(Student st) {
        if (rollno == st.rollno) {
            return 0;
        } else if (rollno > st.rollno) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class TestComparable {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();

        list.add(new Student("zeeshan", 1));
        list.add(new Student("Shaikh", 2));

        Collections.sort(list);
        for (Student st : list) {
            System.out.println(st.rollno + "  " + st.name);
        }
    }
}
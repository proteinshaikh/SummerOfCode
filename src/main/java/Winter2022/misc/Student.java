
package Winter2022.misc;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Student implements Comparable<Student> {

    private String name;
    private int id;
    private double marks;


    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public Student(int id, String name, double marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return this.getName().equals(s.getName()) || this.getId() == s.getId();
    }

    @Override
    public int hashCode() {
        int res = 17;
        res = 31 * res + this.getId();
        res = 31 * res + ((this.getName() != null) ? this.getName().hashCode() : 0);
        return res;
    }


    @Override
    public int compareTo(@NotNull Student o) {
        if (this.getId() > o.getId()) return 1;
        if (this.getId() < o.getId()) return 1;
        return this.getName().compareTo(o.getName());
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student s1 = new Student(1, "zee", 10);
        Student s2 = new Student(3, "akr", 30);
        Student s3 = new Student(2, "sha", 20);
        Student s4 = new Student(2, "sha", 20);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        System.out.println("-------------testing average marks using streams------------------------");

        double avgmarks = list.stream().mapToDouble(x -> x.getMarks()).average().orElse(0.0);
        System.out.println("average marks is: " + avgmarks);

        System.out.println("-------------testing max marks using streams------------------------");
        double maxmarks = list.stream().mapToDouble(x -> x.getMarks()).max().orElse(0.0);
        System.out.println("max marks is: " + maxmarks);

        System.out.println("-------------testing sort student id reverse using streams------------------------");

        List<Student> studentList = list.stream().sorted(Comparator.comparingInt(Student::getId).reversed()).collect(Collectors.toList());
        for (Student s : studentList) {
            System.out.println(s.getId() + " : " + s.getName() + " : " + s.getMarks());
        }

        System.out.println("-------------testing comparables------------------------");
        Collections.sort(list);

        for (Student s : list) {
            System.out.println(s.getId() + " : " + s.getName());
        }

        System.out.println("testing name comparator");
        Collections.sort(list, new Name());
        for (Student s : list) {
            System.out.println(s.getId() + " : " + s.getName());
        }

        System.out.println("testing Id comparator");
        Collections.sort(list, new Id());
        for (Student s : list) {
            System.out.println(s.getId() + " : " + s.getName());
        }

        System.out.println("testing equals and hashcode");
        if (s3.hashCode() == s4.hashCode()) {
            System.out.println("hashcodes are same");
        } else {
            System.out.println("hashcodes are different");
        }
    }
}

class Name implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class Id implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getId() - o2.getId();
    }
}





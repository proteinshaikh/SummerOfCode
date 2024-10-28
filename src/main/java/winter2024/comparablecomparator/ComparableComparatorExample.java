package winter2024.comparablecomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    // Implementing Comparable interface to sort by name (natural order)
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + ", grade=" + grade + '}';
    }
}

public class ComparableComparatorExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22, 8.5));
        students.add(new Student("Bob", 20, 9.0));
        students.add(new Student("Charlie", 23, 7.8));

        // Using Comparable (natural order) to sort by name
        Collections.sort(students);
        System.out.println("Sorted by name using Comparable:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Using Comparator to sort by age
        Comparator<Student> ageComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getAge(), s2.getAge());
            }
        };

        Collections.sort(students, ageComparator);
        System.out.println("\nSorted by age using Comparator:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Using Comparator to sort by grade in descending order
        Comparator<Student> gradeComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getGrade(), s1.getGrade());
            }
        };

        Collections.sort(students, gradeComparator);
        System.out.println("\nSorted by grade (descending) using Comparator:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}


package problems;

import java.util.*;
import java.util.stream.Collectors;

//sort by grade in asc order and if grade is same sort by name
public class ComparableStudents {

    public static void main(String[] args) {
        List<Students> students = new ArrayList<>();
        students.add(new Students(1, "zeeshan", 27));
        students.add(new Students(2, "zeeshan", -3));
        students.add(new Students(3, "zeeshan", 4));
        students.add(new Students(4, "zeeshan", 6));
        students.add(new Students(5, "zeeshan", 310));
        students.add(new Students(6, "zeeshan", 99));

        //using java 7
        //Collections.sort(students);
        //System.out.println(students);

        //using java 8
        System.out.println(students.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()));



    }
}

class Students implements Comparable<Students> {
    private int rollno;
    private String name;
    private int grade;

    public Students(int rollno, String name, int grade) {
        this.rollno = rollno;
        this.name = name;
        this.grade = grade;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "rollno=" + rollno +" "+ "name=" + name +" "+ "grade=" + grade + "\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollno, name, grade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return rollno == students.rollno && grade == students.grade && Objects.equals(name, students.name);
    }

    public int compareTo(Students s) {
        if (this.grade != s.grade) {
            return this.grade - s.grade;
        } else {
            return this.name.compareTo(s.name);
        }

    }
}

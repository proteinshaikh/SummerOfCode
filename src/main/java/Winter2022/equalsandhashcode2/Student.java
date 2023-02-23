package Winter2022.equalsandhashcode2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Student {
    private String name;
    private int rollno;

    public Student(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student s = (Student) o;
        return name.equals(s.getName()) && rollno == s.getRollno();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rollno);
    }

    public static void main(String[] args) {
        Map<Student, Integer> map = new HashMap<>();
        map.put(new Student("zee", 4), 1);
        map.put(new Student("zee", 5), 2);
        map.put(new Student("zee", 6), 3);
        map.put(new Student("test", 6), 3);

        Student st = new Student("zee", 4);

        System.out.println(map.get(st));

        for(Map.Entry<Student, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey().getName());

        }


    }
}

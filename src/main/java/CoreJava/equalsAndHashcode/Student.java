package CoreJava.equalsAndHashcode;

import java.util.Objects;

public class Student {
    private String name;
    private int standard;
    private int rollNo;

    public Student(String name, int standard, int rollNo) {
        this.name = name;
        this.standard = standard;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return standard == student.standard && rollNo == student.rollNo && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, standard, rollNo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", standard=").append(standard);
        sb.append(", rollNo=").append(rollNo);
        sb.append('}');
        return sb.toString();
    }
}

package Winter2022;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int id;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return s.getName().equals(this.getName()) || s.getId() == this.getId();

    }

    @Override
    public int hashCode() {
        int res = 17;
        res = 31 * res + id;
        res = 31 * res + (name != null ? name.hashCode() : 0);
        return res;
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student b1 = new Student(1, "zee");
        Student b2 = new Student(1, "zee");
        list.add(b1);
        list.add(b2);

        if (b1.hashCode() == b2.hashCode()) System.out.println(true);
        else System.out.println(false);


    }
}

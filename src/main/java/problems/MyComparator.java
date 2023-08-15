package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MyComparator {
    public static void main(String[] args) {
        List<Emp> emp = new ArrayList<Emp>();
        emp.add(new Emp(1, "Bat", 25));
        emp.add(new Emp(1, "Cat", 25));
        emp.add(new Emp(3, "Mumbai", 10));
        emp.add(new Emp(4, "India", 5));
        emp.add(new Emp(5, "TEST", 80));

        System.out.println("Sorting by age \n");
        Collections.sort(emp, new AgeSorter());
        for (int i = 0; i < emp.size(); i++) {

            System.out.println(emp.get(i));
        }
        System.out.println("Sorting by name \n");
        Collections.sort(emp, new NameSorter().reversed());
        for (int i = 0; i < emp.size(); i++) {
            System.out.println(emp.get(i));
        }

    }
}

class Emp {
    private int id;
    private String name;
    private int age;

    public Emp(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return id == emp.id &&
                age == emp.age &&
                Objects.equals(name, emp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age + "\n";
    }
}

class AgeSorter implements Comparator<Emp> {

    @Override
    public int compare(Emp e1, Emp e2) {
        return e1.getAge() - e2.getAge();

    }

}

class NameSorter implements Comparator<Emp> {

    @Override
    public int compare(Emp e1, Emp e2) {
        return e1.getName().compareTo(e2.getName());
    }
}

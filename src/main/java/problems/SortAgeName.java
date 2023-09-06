package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortAgeName {
    public static void main(String[] args) {
        List<Employees> employees = new ArrayList<>();
        employees.add(new Employees(1, "Bat", 25));
        employees.add(new Employees(1, "Cat", 25));
        employees.add(new Employees(3, "Mumbai", 10));
        employees.add(new Employees(4, "India", 5));
        employees.add(new Employees(5, "TEST", 80));


        employees.sort((e, e1) -> {
            int res = Integer.compare(e.getAge(), e1.getAge());
            if (res != 0) {
                res = e.getName().compareTo(e1.getName());
            }
            return res;
        });
        System.out.println(employees +"\n");
        System.out.println(employees +"\n");


    }
}

class Employees {
    public Employees(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private int id;
    private String name;
    private int age;

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
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

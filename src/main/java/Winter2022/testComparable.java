package Winter2022;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee> {

    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
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
    public int compareTo(Employee e) {
        if (id > e.getId()) return 1;
        if (id < e.getId()) return -1;
        return name.compareTo(e.getName());
    }
}

public class testComparable {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("zeeshan", 1));
        employees.add(new Employee("akram", 2));
        employees.add(new Employee("shaikh", 3));
        employees.add(new Employee("protein", 4));
        employees.add(new Employee("carbs", 5));
        employees.add(new Employee("gym", 6));
        employees.add(new Employee("fats", 6));

        Collections.sort(employees);
        for (Employee employee : employees) {
            System.out.println("name : " + employee.getName() + " " + "Id : " + employee.getId());
        }
    }
}

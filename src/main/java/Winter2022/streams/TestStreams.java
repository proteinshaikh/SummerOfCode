package Winter2022.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestStreams {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(3, "zeeshan"));
        employees.add(new Employee(1, "akram"));
        employees.add(new Employee(2, "shaikh"));

        List<Employee> sortbyid = employees.stream().sorted(Comparator.comparingInt(Employee::getId).reversed()).collect(Collectors.toList());
        sortbyid.forEach(System.out::println);
    }
}

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

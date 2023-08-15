package Winter2022.comparable2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestComparable {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Zeeshan", 1));
        employees.add(new Employee("Akram", 3));
        employees.add(new Employee("Shaikh", 0));
        employees.add(new Employee("Zeeshan", 2));

        Collections.sort(employees);

        for (Employee e : employees) {
            System.out.println(e.getName() + " " + e.getId());
        }
    }
}

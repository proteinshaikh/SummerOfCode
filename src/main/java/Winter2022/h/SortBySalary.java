package Winter2022.h;

import Winter2022.c.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortBySalary {

    public static void main(String[] args) {
        List<Winter2022.c.Employee> list = new ArrayList<>();
        list.add(new Employee(1, "asas", 66));
        list.add(new Employee(2, "dfdf", 33434));
        list.add(new Employee(2, "ghgh", 8989));

        List<Employee> employees = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).toList();

        for (Employee e : employees) {
            System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());
        }
    }
}

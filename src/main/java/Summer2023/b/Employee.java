package Summer2023.b;

import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Builder
@Data
public class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private long salary;
    private String department;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                salary == employee.salary &&
                Objects.equals(name, employee.name) &&
                Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, department);
    }

    @Override
    public int compareTo(Employee other) {
        if (id > other.getId()) return -1;
        if (id < other.getId()) return 1;

        // if id is same compare names
        int nameComp = name.compareTo(other.getName());
        if (nameComp != 0) return nameComp;

        //if name is same compare by salary\
        if (id > other.getSalary()) return 1;
        if (id < other.getSalary()) return -1;

        return department.compareTo(other.getDepartment());
    }

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "zeeshan", 1000, "IT"),
                new Employee(2, "zeeshan", 2000, "HR"),
                new Employee(3, "zeeshan", 3000, "Support")
        );
        Collections.sort(employees);
        //employees.sort(new SalaryComparator().SALARY_COMPARATOR);

        for (Employee e : employees) {
            System.out.println(e.getSalary() + " " + e.getId());
        }

    }
}

class SalaryComparator implements Comparator<Employee> {

    public Comparator<Employee> SALARY_COMPARATOR = Comparator.comparing(Employee::getSalary).reversed();

    @Override
    public int compare(Employee e1, Employee e2) {
        return (int) (e1.getSalary() - e2.getSalary());
    }


}

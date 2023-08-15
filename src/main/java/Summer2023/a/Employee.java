package Summer2023.a;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Data
@Builder
//@EqualsAndHashCode //TODO when using lombok use this
public class Employee implements Comparable<Employee> {

    private final int id;
    private final String name;
    private final BigDecimal salary;

    public static final Comparator<Employee> SALARY_COMPARATOR = Comparator.comparing(Employee::getSalary);
    public static final Comparator<Employee> NAME_COMPARATOR = Comparator.comparing(Employee::getName);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee e = (Employee) o;
        return id == e.getId() &&
                Objects.equals(name, e.getName()) &&
                Objects.equals(salary, e.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }

    @Override
    public int compareTo(Employee e) {
        int salaryComparison = this.salary.compareTo(
                e.getSalary()
        );
        if (salaryComparison != 0) {
            return salaryComparison;
        }
        return this.getName().compareTo(e.getName());
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(10, "zeeshan", BigDecimal.valueOf(1000)),
                new Employee(20, "akram", BigDecimal.valueOf(2000)),
                new Employee(30, "shaikh", BigDecimal.valueOf(5000)),
                new Employee(40, "test", BigDecimal.valueOf(3000))
        );

        Map<Integer, Employee> map = new HashMap<>();
        map.put(1, new Employee(10, "zeeshan", BigDecimal.valueOf(1000)));
        map.put(2, new Employee(20, "akram", BigDecimal.valueOf(2000)));
        map.put(3, new Employee(30, "shaikh", BigDecimal.valueOf(5000)));
        map.put(4, new Employee(40, "test", BigDecimal.valueOf(3000)));

        System.out.println("distinct id using streams");
        for (Employee e : employees.stream().distinct().sorted(Comparator.comparingInt(Employee::getId)).toList()) {
            System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());
        }

        System.out.println("average salary using streams");
        Optional<BigDecimal> averageSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal::add)
                .map(total -> total.divide(
                        BigDecimal.valueOf(employees.size()), RoundingMode.HALF_UP)
                );
        System.out.println("average Salary is : " + averageSalary.get());


        System.out.println("max salary using streams");
        Optional<BigDecimal> max = employees.stream()
                .map(Employee::getSalary)
                .max(BigDecimal::compareTo);
        System.out.println("max salary is : " + max.get());

        System.out.println("sort employee id reverse using streams");
        for (Employee e : employees.stream().sorted(Comparator.comparingInt(Employee::getId).reversed()).toList()) {
            System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());
        }

        System.out.println("sort employees by salary");

        for (Employee e : employees.stream().sorted(Comparator.comparing(Employee::getSalary)).toList()) {
            System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());
        }

        System.out.println("foreach method in hashmap new java 8");
        map.forEach((key, value) -> System.out.println(key + " " + value.getId() + " " + value.getName() + " " + value.getSalary()));

        System.out.println("comparable"); //DONE

        System.out.println("comparators name");
        employees.sort(Employee.NAME_COMPARATOR);
        for (Employee e : employees) {
            System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());
        }

        System.out.println("comparators salary");
        employees.sort(Employee.SALARY_COMPARATOR);
        for (Employee e : employees) {
            System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());
        }

        System.out.println("equals and hashcode"); //DONE

        System.out.println("ExThread");
        System.out.println("Threads Runnable");
        System.out.println("thread safe singleton using executor");
        System.out.println("builder");
        System.out.println("factory");
        System.out.println("two sum");
        System.out.println("count words");
        System.out.println("factorial using recursion");
        System.out.println("rotate array");
        System.out.println("flatmap");
        System.out.println("lambda exp");
        System.out.println("delete/merge hashmap entries");
        System.out.println("find common elements between 2 arrays");
        System.out.println("apache poi");
        System.out.println("count the number of occurrences of each alphabet in a sentence using streams");
        System.out.println("3rd highest salary sql");
        System.out.println("first non repeated character");
        System.out.println("immutable threadsafe");
        System.out.println("leader array");
        System.out.println("most common element");
        System.out.println("Optional empty list");
        System.out.println("sort millions of data from database in batches (know)");
        System.out.println("remove duplicates from list");
        System.out.println("reverse alphabets");
        System.out.println("scope of beans");
        System.out.println("get 2nd largest num from list");
        System.out.println("total salary of all employees whose age is greater than 30");
        System.out.println("maximum salary of all employees in a department");
        System.out.println("find the first five even numbers greater than 10");
        System.out.println("String reverse");
        System.out.println("read file in sync");
        System.out.println("circuit breaker config");
        System.out.println("prevent clone");
        System.out.println("covarient return types");
        System.out.println("poi");
        System.out.println("count alphabets using streams");
        System.out.println("abstract enums");
        System.out.println("read db data sort");
        System.out.println("streams hub");
        System.out.println("compress string using map");

    }
}

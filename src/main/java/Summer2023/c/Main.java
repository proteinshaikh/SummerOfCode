package Summer2023.c;

import org.springframework.util.comparator.Comparators;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    private static final String string = "hi my name is zeeshan akram shaikh. is zeeshan akram shaikh. akram shaikh";

    private static final int[] arr = new int[]{1, 2, 3, 4, 5, 6, 4, 5, 6, 7, 8, 0, 3, 4};

    private static final List<Employee> employeeList = Arrays.asList(
            new Employee(1, "john", 25, 5, 5000, "IT"),
            new Employee(2, "doe", 34, 7, 6000, "HR"),
            new Employee(3, "mary", 53, 6, 7000, "IT"),
            new Employee(4, "bob", 35, 5, 12000, "MED"),
            new Employee(5, "ros", 21, 3, 3400, "IT"),
            new Employee(6, "sheldon", 44, 6, 7000, "FIN"),
            new Employee(7, "rik", 44, 9, 5600, "IT"),
            new Employee(8, "penny", 21, 10, 6400, "FIN"),
            new Employee(9, "raj", 33, 5, 3000, "HR"),
            new Employee(10, "raj", 29, 7, 10000, "MED")

    );

    private static final Map<Integer, Employee> employeeMap = employeeList.stream().collect(Collectors.toMap(Employee::getId, employee -> employee));


    // program to get duplicates from an array and print the duplicates
    static void duplicates() {
        //for integers
        Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((k, v) -> System.out.println(k + " = " + v));

        //for String

        Arrays.stream(string.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }

    //program to find distinct salary of employees using streams
    static void distinctId() {
        employeeList.stream()
                .map(Employee::getSalary)
                .distinct()
                .toList()
                .forEach(System.out::println);
    }

    //program to find sum of salaries in each department
    static void sumOfSalariesInEachDept() {
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)))
                .forEach((x, y) -> System.out.println(x + " = " + y));
        System.out.println();

        //with map
        employeeMap.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)))
                .forEach((x, y) -> System.out.println(x + " = " + y));
    }

    //program to find count of each character in a string
    static void countOfEachCharsInString() {

        string.chars()
                .mapToObj(c -> (char) c)
                .filter(x -> !(x == '.') && !(x == ' '))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }

    public static void main(String[] args) {
        //countOfEachCharsInString();
        //sumOfSalariesInEachDept();
        //distinctId();
        //duplicates();

    }
}

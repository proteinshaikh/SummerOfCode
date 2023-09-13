package Summer2023.c;

import Summer2023.a.defaultInterfaces.A;
import kotlin.jvm.Synchronized;
import org.apache.commons.math3.analysis.function.Sin;
import org.springframework.util.comparator.Comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    //program to check if a string is palindrome or not
    static void palindrome() {
        String str = "radar";

        boolean res = IntStream.rangeClosed(0, str.length() / 2)
                .allMatch(x -> str.charAt(x) == str.charAt(str.length() - x - 1));
        System.out.println(res);
    }

    //program to find factorial
    static int factorial(int num) {
        if (num == 0 || num == 1) return 1;

        return num * factorial(num - 1);
    }

    // program to define thread safe singleton

    static class Singleton {
        private static volatile Singleton instance;

        private Singleton() {
        }

        public Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }

        public void doSomething() {
            System.out.println("did something!");
        }
    }

    //program to rotate array left using streams
    static void rotateArray() {
        IntStream.rangeClosed(0, arr.length - 1)
                .boxed()
                .map(i -> {
                    if (i == 0) return arr[arr.length - 2];
                    if (i == 1) return arr[arr.length - 1];
                    return arr[i - 2];
                })
                .toList()
                .forEach(System.out::println);
    }

    //program to check if list of numbers are divisible by 3
    static void divisibleBy3() {
        Arrays.stream(arr)
                .boxed()
                .filter(x -> x % 3 == 0 && x != 0)
                .toList()
                .forEach(System.out::println);
    }

    // program to sum numbers in list
    static void sumNumsInList() {
        int sum = Arrays.stream(arr)
                .sum();
        System.out.println(sum);
    }

    //program to demonstrate reduce using streams
    static void reduce() {
        int sum = Arrays.stream(arr)
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    //program to find max without max method
    static void max() {
        Optional<Integer> max = Arrays.stream(arr)
                .boxed().max(Comparator.comparingInt(Integer::valueOf));
        System.out.println(max);
    }

    //program to generate even numbers between 100 and 200
    static void generateEvenNums() {
        IntStream.rangeClosed(100, 200)
                .boxed()
                .filter(x -> x % 2 == 0)
                .toList()
                .forEach(System.out::println);
    }

    // program to delete map entries
    static void deleteMapEntries() {
        employeeMap.keySet()
                .stream()
                .filter(x -> x != 2 && x != 7)
                .toList()
                .forEach(System.out::println);
    }

    //program to reverse array
    static void reverseArray() {
        IntStream.rangeClosed(0, arr.length - 1)
                .map(x -> arr[x] = arr[arr.length - x - 1])
                .boxed()
                .toList()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        //reverseArray();
        //deleteMapEntries();
        //generateEvenNums();
        //max();
        //reduce();
        //sumNumsInList();
        //divisibleBy3();
        //rotateArray();
        //System.out.println(factorial(5));
        //palindrome();
        //countOfEachCharsInString();
        //sumOfSalariesInEachDept();
        //distinctId();
        //duplicates();

    }
}

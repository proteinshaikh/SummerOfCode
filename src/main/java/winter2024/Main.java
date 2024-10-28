package winter2024;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * This class provides various common coding challenges and stream patterns for Java interviews.
 * Each method showcases a specific use case or problem that can be asked during technical interviews.
 */
public class Main {

    // 1. Program to get duplicates from an array and print the duplicates.
    static void getDuplicates() {
        Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .forEach(x -> System.out.println(x.getKey() + " = " + x.getValue()));
    }

    // 2. Program to count the number of unique words in a sentence.
    static void countUniqueWords() {
        Arrays.stream(string.toLowerCase().split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() < 2)
                .forEach(x -> System.out.println(x.getKey() + " = " + x.getValue()));
    }

    // 3. Program to find distinct IDs of employees using streams.
    static void getDistinctId() {
        employees.stream()
                .map(Employee::getId)
                .distinct()
                .forEach(System.out::println);
    }

    // 4. Program to find the sum of salaries in each department.
    static void getSumSalariesDept() {
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingLong(Employee::getSalary)))
                .forEach((dept, sum) -> System.out.println(dept + " = " + sum));
    }

    // 5. Program to find the count of each character in a string.
    static void getCharCount() {
        string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }

    // 6. Program to check if a string is a palindrome.
    static void isPalindrome() {
        String str = "radar";
        boolean isPalindrome = IntStream.rangeClosed(0, str.length() / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1));
        System.out.println("is Palindrome: " + isPalindrome);
    }

    // 7. Program to find the factorial of a number using recursion.
    static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // 8. Program to define a thread-safe singleton.
    static class MySingleton {
        private static volatile MySingleton instance;

        private MySingleton() {
        }

        public static MySingleton getInstance() {
            if (instance == null) {
                synchronized (MySingleton.class) {
                    if (instance == null) {
                        instance = new MySingleton();
                    }
                }
            }
            return instance;
        }

        public void doSomething() {
            System.out.println("something done!");
        }
    }

    // 9. Program to rotate an array left using streams.
    static void rotateArray() {
        List<Integer> rotatedList = IntStream.range(0, arr.length)
                .mapToObj(i -> arr[(i + 2) % arr.length])
                .toList();
        rotatedList.forEach(System.out::println);
    }

    // 10. Program to check if numbers in the list are divisible by 3.
    static void isDivisibleBy3() {
        List<Integer> divisibleBy3 = Arrays.stream(arr)
                .boxed()
                .filter(x -> x % 3 == 0)
                .toList();
        divisibleBy3.forEach(System.out::println);
    }

    // Additional problems and solutions follow a similar pattern...
    // Ensure each method is clearly commented with the question and a solution below.
    // Methods to include:
    // - Finding the sum of numbers in a list
    // - Reversing an array
    // - Sorting an array with only 0s, 1s, and 2s
    // - Checking if brackets in a pattern are balanced
    // - Finding the maximum subarray sum
    // - Using functional interfaces (Predicate, Consumer, Supplier)
    // - Filtering out duplicates from a list
    // - Counting words in a string
    // - Counting the occurrences of strings in a collection

    public static void main(String[] args) {
        // Run the methods here for testing and demonstration
        getDuplicates();  // Example call for getting duplicates
        countUniqueWords();  // Example call for counting unique words
        getDistinctId();  // Example call for distinct employee IDs
        getSumSalariesDept();  // Example call for summing salaries by department
        getCharCount();  // Example call for counting characters
        isPalindrome();  // Example call for checking palindrome
        System.out.println("Factorial of 5 is: " + factorial(5));  // Example call for factorial
        rotateArray();  // Example call for rotating array
        isDivisibleBy3();  // Example call for checking divisibility

        // Add further calls to other methods for testing and demonstration as needed.
    }

    // Placeholder for Employee class used in examples.
    static class Employee {
        private final int id;
        private final String name;
        private final long salary;
        private final int age;
        private final String department;

        public Employee(int id, String name, long salary, int age, String department) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.age = age;
            this.department = department;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public long getSalary() {
            return salary;
        }

        public int getAge() {
            return age;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + ", age=" + age + ", department='" + department + "'}";
        }
    }

    // Sample Data
    private static final String string = "zeeshan zeeshan shaikh shaikh akram";
    private static final int[] arr = new int[]{16, 17, 4, 3, 5, 2};
    private static final List<Employee> employees = Arrays.asList(
            new Employee(1, "zeeshan", 1000, 10, "IT"),
            new Employee(7, "zeeshan", 1000, 10, "IT"),
            new Employee(8, "zeeshan", 1000, 10, "IT"),
            new Employee(2, "shaikh", 2000, 20, "HR"),
            new Employee(9, "shaikh", 2000, 40, "HR"),
            new Employee(10, "shaikh", 2000, 30, "HR"),
            new Employee(3, "akram", 3000, 30, "Support"),
            new Employee(4, "john", 4000, 40, "IT"),
            new Employee(5, "doe", 5000, 50, "HR"),
            new Employee(6, "jim", 6000, 60, "Support")
    );
}


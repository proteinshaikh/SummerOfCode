package Summer2023.b;

import kotlin.jvm.Synchronized;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    private static final String string = "zeeshan zeeshan shaikh";

    private static final int[] arr = new int[]{1, 2, 3, 4, 9, 15, 21};
    private static final List<Employee> employees = Arrays.asList(
            new Employee(1, "zeeshan", 1000, "IT"),
            new Employee(2, "shaikh", 2000, "HR"),
            new Employee(3, "akram", 3000, "Support"),
            new Employee(4, "john", 4000, "IT"),
            new Employee(5, "doe", 5000, "HR"),
            new Employee(6, "jim", 6000, "Support")
    );

    // program to get duplicates from an array and print the duplicates
    static void getDuplicates() {
        Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((k, v) -> System.out.println(k + "=" + v));
    }

    //program to count number of words in a sentence

    static void countUniqueWords() {
        Arrays.stream(string.toLowerCase().split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() < 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }

    //program to find distinct id of employees using streams

    static void getDistinctId() {
        for (int e : Main.employees.stream().map(Employee::getId).distinct().toList()) {
            System.out.println(e);
        }
    }

    //program to find sum of salaries in each department

    static void getSumSalariesDept() {
        Main.employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summingLong(Employee::getSalary)
                ))
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }

    //program to find count of each characters in a string
    static void getCharCount() {
        string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }

    //program to check if a string is palindrome or not

    static void isPalindrome() {
        String str = "radar";

        boolean isPalindrome = IntStream.rangeClosed(0, str.length() / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1));
        System.out.println("is Palindrome: " + isPalindrome);
    }

    //program to find factorial

    static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // program to define thread safe singleton

    static class MySingleton {
        private static volatile MySingleton instance;

        private MySingleton() {
        }

        public MySingleton getInstance() {
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

    enum ESingleton {
        INSTANCE;

        public void doSomething() {
            System.out.println("something done!");
        }
    }

    //program to rotate array left using streams

    static void rotateArray() {
        List<Integer> list = IntStream.rangeClosed(0, arr.length - 1)
                .boxed()
                .map(i -> {
                    if (i == 0) return arr[arr.length - 2];
                    if (i == 1) return arr[arr.length - 1];
                    return arr[i - 2];
                })
                .toList();
        for (int a : list) {
            System.out.println(a);
        }
    }

    //program to check if list of numbers are divisible by 3
    static void isDivisibleBy3() {
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .filter(x -> x % 3 == 0)
                .toList();
        for (int a : list) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        isDivisibleBy3();
        rotateArray();
        System.out.println(factorial(4));
        isPalindrome();
        getCharCount();
        getSumSalariesDept();
        getDuplicates();
        countUniqueWords();
        getDistinctId();
    }

}



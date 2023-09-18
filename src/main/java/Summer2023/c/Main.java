package Summer2023.c;

import Summer2023.a.defaultInterfaces.A;
import kotlin.jvm.Synchronized;
import org.apache.commons.math3.analysis.function.Sin;
import org.springframework.util.comparator.Comparators;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    private static final String string = "hi my name is zeeshan akram shaikh. is zeeshan akram shaikh. akram shaikh";

    private static final int[] arr = new int[]{1, 2, 3, 4, 5, 6, 4, 5, 6, 7, 8, 0, 3, 4, 153, 370};

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

    // You have been given an integer array/list(ARR) of size 'N'. It only contains 0s, 1s and 2s. Write a solution to sort this array/list.
    static void sortArray() {
        int[] array = new int[]{0, 1, 1, 0, 0, 2, 1, 1, 2};
        Arrays.stream(array)
                .boxed()
                .sorted(Comparator.naturalOrder())
                .toList()
                .forEach(System.out::println);
    }

    //Largest Sum Contiguous SubArray (Kadane’s Algorithm)
    static void maxSubArraySum() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSoFar = arr[0];
        int currentMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        System.out.println(maxSoFar);
    }

    //program for supplier, consumer, and predicate
    static void funcInterfaces() {
        Predicate<Integer> predicate = x -> x > 2;
        boolean res = predicate.test(4);
        System.out.println(res);

        Supplier<Integer> supplier = () -> new Random().nextInt(5);
        System.out.println(supplier.get());

        Consumer<String> consumer = System.out::println;
        consumer.accept("test");

        Consumer<String> consumer1 = str -> System.out.println(str.toUpperCase());
        consumer1.accept("zeeshan");
    }

    // program to swap integers
    static void swapIntegers() {
        int[] array = new int[]{1, 2};

        IntStream.rangeClosed(0, array.length - 1)
                .boxed()
                .map(i -> array[array.length - i - 1])
                .toList()
                .forEach(System.out::println);
    }

    // Program to create streams

    static void createStreams() {
        Stream.of(1, 2, 3, 4, 5)
                .skip(3)
                .limit(1)
                .toList()
                .forEach(System.out::println);
    }

    // Convert a list of strings to a map of their lengths using streams.
    static void listOfStringsToMapOfLengths() {
        Arrays.stream(string.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }

    // find max and min number from a list
    static void maxAndMinFromList() {
        Optional<Integer> max = Arrays.stream(arr)
                .boxed()
                .max(Comparator.comparingInt(Integer::valueOf));
        System.out.println(max);

        Optional<Integer> min = Arrays.stream(arr)
                .boxed()
                .min(Comparator.comparingInt(Integer::valueOf));
        System.out.println(min);
    }

    //Find the top N elements from a list.
    static void topNElementsFromList() {
        Arrays.stream(arr)
                .boxed()
                .limit(5)
                .toList()
                .forEach(System.out::println);
    }

    //program to filter employee name ends with
    static void employeeNameEndsWith() {
        employeeList.stream()
                .filter(x -> x.getName().endsWith("b"))
                .toList()
                .forEach(System.out::println);
    }

    //find armstrong number nums from list
    static void armstrongNumber() {
        //System.out.println(153 % 10);
        int sum = 0;
        int temp;
        for (int a : Arrays.stream(arr).boxed().toList()) {
            int orgNum = a;
            while (a != 0) {
                temp = a % 10;
                int pow = (int) Math.pow(temp, 3);
                sum += pow;
                a = a / 10;
            }
            if (sum != 0 & orgNum == sum) {
                System.out.println("armstrong number = " + sum);
            }
            sum = 0;

        }
    }

    //Convert a list of objects to a map with a specific attribute as the key.
    static void listToMap() {
        employeeList.stream()
                .collect(Collectors.toMap(Employee::getId, employeeList -> employeeList))
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }

    // program to demo threads
    static class ExThread extends Thread {
        @Override
        public void run() {
            System.out.println("exthread: " + Thread.currentThread().getId());

        }
    }

    static class RunThread implements Runnable {

        @Override
        public void run() {
            System.out.println("runThread: " + Thread.currentThread().getId());
        }
    }

    // Program to filter out empty strings from list
    static void filterEmptyStreams() {
        List<String> strings = Arrays.asList("", "zeeshan", "test", "", "H");
        strings.stream()
                .filter(x -> !Objects.equals(x, ""))
                .toList()
                .forEach(System.out::println);
    }

    // program to generate random integers from 100 to 200
    static void generateRandomNumbers() {
        IntStream.generate(() -> 100 + new Random().nextInt(100))
                .limit(5)
                .boxed()
                .toList()
                .forEach(System.out::println);
    }

    // Program to print names 10 times
    static void printNamesMultipleTimes() {
        IntStream.rangeClosed(0, 9)
                .forEach(x -> System.out.println("zeeshan"));
    }

    // Program to count alphabets using streams
    static void countAlphabets() {
        string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> !x.getKey().equals('.') & !x.getKey().equals(' '))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }


    public static void main(String[] args) throws InterruptedException {
        //countAlphabets();
        //printNamesMultipleTimes();
        //generateRandomNumbers();
        //filterEmptyStreams();
        /*Thread t1 = new ExThread();
        Thread t2 = new Thread(new RunThread());
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();*/

        //listToMap();
        //armstrongNumber();
        //employeeNameEndsWith();
        //topNElementsFromList();
        //maxAndMinFromList();
        //listOfStringsToMapOfLengths();
        //createStreams();
        //swapIntegers();
        //funcInterfaces();
        // maxSubArraySum();
        //sortArray();
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

package Summer2023.b;

import org.apache.poi.ss.formula.functions.T;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    private static final String string = "zeeshan zeeshan shaikh shaikh akram";

    private static final int[] arr = new int[]{16, 17, 4, 3, 5, 2};

    private static final List<Employee> employees = Arrays.asList(
            new Employee(1, "zeeshan", 1000, 10, "IT"),
            new Employee(7, "zeeshan", 1000, 10, "IT"),
            new Employee(8, "zeeshan", 1000, 10, "IT"),
            new Employee(2, "shaikh", 2000, 20, "HR"),
            new Employee(9, "shaikh", 2000, 20, "HR"),
            new Employee(3, "akram", 3000, 30, "Support"),
            new Employee(4, "john", 4000, 40, "IT"),
            new Employee(5, "doe", 5000, 50, "HR"),
            new Employee(6, "jim", 6000, 60, "Support")
    );


    private static final Map<Integer, Employee> map = employees.stream()
            .collect(Collectors.toMap(Employee::getId, employees -> employees));


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

    // program to sum numbers in list

    static void sum() {
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);
    }

    //program to demonstrate reduce using streams
    static void reduce() {
        int sum = Arrays.stream(arr).reduce(0, Integer::sum);
        System.out.println(sum);
    }

    //program to generate even numbers between 100 and 200

    static void even() {
        IntStream.rangeClosed(100, 200)
                .filter(x -> x % 2 == 0)
                .boxed()
                .toList()
                .forEach(System.out::println);
    }

    static void deleteMapEntries() {
        map.entrySet().stream()
                .filter(x -> x.getKey() != 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }

    //program to reverse array
    static void reverseArray() {
        IntStream.rangeClosed(0, arr.length - 1)
                .map(i -> arr[i] = arr[arr.length - i - 1])
                .boxed()
                .toList()
                .forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    // You have been given an integer array/list(ARR) of size 'N'. It only contains 0s, 1s and 2s. Write a solution to sort this array/list.

    static void sort() {
        int[] ints = new int[]{1, 1, 2, 2, 0, 0, 0, 2, 1, 1, 1, 2};

        Arrays.stream(ints)
                .boxed()
                .sorted(Comparator.naturalOrder())
                .toList()
                .forEach(x -> System.out.print(x + " "));
    }

    static void maxSubArraySum() {
        int result = IntStream.rangeClosed(0, arr.length)
                .boxed()
                .flatMapToInt(i -> IntStream.rangeClosed(i, arr.length)
                        .map(j -> Arrays.stream(arr, i, j).sum()))
                .max().orElse(0);
        System.out.println(result);
    }

    static void maxSubArray() {
        IntStream.rangeClosed(0, arr.length)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i + 1, arr.length)
                        .mapToObj(j -> new AbstractMap.SimpleEntry<>(i, j)))
                .max(Comparator.comparingInt(e -> Arrays.stream(arr, e.getKey(), e.getValue()).sum()))
                .map(e -> {
                    int[] subArray = Arrays.copyOfRange(arr, e.getKey(), e.getValue());
                    return new AbstractMap.SimpleEntry<>(e.getKey() + " to " + (e.getValue() - 1), subArray);
                })
                .stream()
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue))
                .forEach((k, v) -> System.out.println(k + " = " + Arrays.toString(v)));
    }

    //program for supplier, consumer, and predicate

    static void functionalInterfaces() {

        // Predicate
        Predicate<Integer> predicate = x -> x > 2;
        System.out.println(predicate.test(4));

        // Consumer
        Consumer<String> consumer = System.out::println;
        Consumer<String> upperCase = str -> System.out.println(str.toUpperCase());
        Consumer<String> printBoth = consumer.andThen(upperCase);
        printBoth.accept("zeeshan");

        // Supplier
        Supplier<Integer> supplier = () -> new Random().nextInt(5);
        System.out.println(supplier.get());
    }

    // program to swap integers

    static void swap() {
        int[] arr = new int[]{1, 2};

        Arrays.stream(IntStream.rangeClosed(0, arr.length - 1)
                        .boxed()
                        .map(i -> arr[arr.length - i - 1])
                        .toArray())
                .toList()
                .forEach(System.out::println);
    }

    // Program to create streams
    static void createStreams() {
        Arrays.stream(Stream.of(1, 2, 3, 4, 5)
                        .toArray())
                .skip(2)
                .limit(2)
                .forEach(System.out::println);
    }

    // Convert a list of strings to a map of their lengths using streams.
    static void stringToLength() {
        Arrays.stream(string.split(" "))
                .distinct()
                .collect(Collectors.toMap(String::valueOf, x -> x.length()))
                .forEach((key, value) -> System.out.println(key + " = " + value));
    }

    // find max and min number from a list
    static void minMax() {
        Arrays.stream(arr)
                .boxed()
                .max(Comparator.naturalOrder())
                .ifPresent(System.out::println);

        Arrays.stream(arr)
                .boxed()
                .min(Comparator.naturalOrder())
                .ifPresent(System.out::println);
    }

    //Find the top N elements from a list.
    static void topElements() {
        Arrays.stream(arr)
                .boxed()
                .limit(2)
                .toList()
                .forEach(System.out::println);
    }

    //Convert a list of objects to a map with a specific attribute as the key.
    static void listToMap() {
        employees.stream()
                .collect(Collectors.toMap(Employee::getId, employees -> employees))
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }

    // program to find max subArray

    static void getMaxSubArray(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < arr.length - k; i++) {
            for (int j = i; j <= k + i - 1; j++) {
                sum = sum + arr[j];
            }
            list.add(sum);
            sum = 0;
        }

        Optional<Integer> max = list.stream().max(Comparator.naturalOrder());
        System.out.println(max.isPresent() ? max.get() : false);
    }

    // program to demo threads
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("my thread" + Thread.currentThread().getId());
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("my thread" + Thread.currentThread().getId());
        }
    }

    void runThreads() throws InterruptedException {
        Thread t1 = new MyThread();
        Thread t2 = new Thread(new MyRunnable());
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }

    // Program to filter out empty streams from list
    static void filterEmptyStrings() {
        List<String> strings = Arrays.asList("zeeshan", "", "shaikh", " ", "test");

        strings.stream()
                .filter(x -> !Objects.equals(x, ""))
                .toList()
                .forEach(System.out::println);
    }

    // program to generate random integers from 100 to 200

    static void generateRandom() {
        IntStream.generate(() -> 100 + new Random().nextInt(100))
                .limit(5)
                .boxed()
                .toList()
                .forEach(System.out::println);
    }

    // Program to print names 10 times
    static void printNames() {
        IntStream.rangeClosed(0, 10)
                .forEach(x -> System.out.println("zeeshan"));
    }

    // Program to count alphabets using streams

    static void countAlphabets() {
        string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }

    // Program to reverse String
    static void reverseString() {

        String str = "zeeshan";
        IntStream.rangeClosed(0, str.length() - 1)
                .mapToObj(i -> str.charAt(str.length() - i - 1))
                .map(String::valueOf)
                .toList()
                .forEach(System.out::print);
    }

    static void evenGreaterThanN() {
        IntStream.rangeClosed(10, 100)
                .boxed()
                .filter(x -> x % 2 == 0)
                .limit(5)
                .toList()
                .forEach(System.out::println);
    }

    // program to find maximum salary of all employees in a department

    static void maxSalaryDepartment() {
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .forEach((key, value) -> System.out.println(key + " = " + value));

    }

    static void totalSalaryByAge() {
        long sum = employees.stream()
                .filter(x -> x.getAge() > 30)
                .mapToLong(Employee::getSalary).sum();
        System.out.println(sum);

    }

    // program to get 2nd largest num from list
    static void get2ndLargestNum() {
        Optional<Integer> nthLargest = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println(nthLargest);
    }

    // program to print duplicates and their occurrences from Employee object

    static void getDuplicateOccurrences() {
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((key, value) -> System.out.println(key + " = " + value));
    }

    // Program to remove duplicates from list of strings

    static void removeDuplicates() {

        Arrays.stream(string.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((key, value) -> System.out.println(key + " = " + value));
    }

    // Program to find most common element in an array
    static void mostCommon() {
        Optional<Integer> mostCommon = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey);
        System.out.println(mostCommon);

    }

    // Program to check if brackets are in pattern

    static void checkPattern() {
        String pattern = "{[()]}";
        Map<Character, Character> map = new HashMap<>();

        {
            map.put('}', '{');
            map.put(']', '[');
            map.put(')', '(');
        }

        Stack<Character> stack = new Stack<>();

        boolean result = pattern.chars()
                .mapToObj(c -> (char) c)
                .allMatch(x ->
                {
                    if (map.containsValue(x)) {
                        stack.push(x);
                        return true;
                    }
                    if (map.containsKey(x)) {
                        return stack.pop() == map.get(x);
                    }
                    return true;
                }) && stack.isEmpty();

        System.out.println("is pattern valid: " + result);
    }

    // Program to find leader array. The rightmost element is always a leader.

    static void leaderArray() {
        IntStream.range(0, arr.length)  // Create a stream of indices
                .boxed()                       // Box them to Integer objects
                .collect(Collectors.collectingAndThen(  // Use this to reverse the list after collection
                        Collectors.toList(),
                        list -> {
                            Collections.reverse(list);
                            return list.stream();
                        }))
                .collect(Collectors.toMap(
                        i -> i,                   // Use index as the key
                        i -> arr[i],              // Use array value as the value
                        (oldVal, newVal) -> oldVal,  // In case of key collision, keep the old value
                        LinkedHashMap::new))  // Maintain insertion order
                .values()
                .stream()
                .filter(new Predicate<>() {
                    private int maxSoFar = Integer.MIN_VALUE;

                    @Override
                    public boolean test(Integer value) {
                        if (value > maxSoFar) {
                            maxSoFar = value;
                            return true;
                        }
                        return false;
                    }
                })
                .toList()
                .forEach(System.out::println);
    }

    // Program to find first non-repeated character
    static void firstNonRepeatedChar() {
        string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .findFirst()
                .ifPresent(System.out::println);
    }

    // SQL to find 3rd highest salary

    String nThHighestSalary = "select * from employee where (select distinct salary from employee order by salary desc limit 2, 1)";


    // Program to find common elements between 2 arrays

    static void commonElements() {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{4, 5, 6, 7, 8};

        Arrays.stream(arr1)
                .distinct()
                .boxed()
                .filter(x -> Arrays.stream(arr2).anyMatch(y -> y == x))
                .forEach(System.out::println);
    }

    // Program to delete/merge hashmap entries
    static void modifyMap() {
        employees.stream()
                .skip(1)
                .toList()
                .forEach(System.out::println);

    }

    // Program to demonstrate lambda expression

    interface Shape {
        String square(int side);
    }

    interface EmployeeInt {
        Employee getEmployee(Employee employee);

    }

    //Program to find factorial
    static int getfactorial(int n) {
        if (n <= 1) return 1;

        return n * factorial(n - 1);

    }

    // program to count words in a string
    static void countWords() {
        Arrays.stream(string.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " = " + value));
    }

    // program to merge 3 arrays into 1
    static void mergeArrays() {
        Integer[] arr1 = {3, 4, 5};
        Integer[] arr2 = {1, 2, 3};
        Integer[] arr3 = {4, 5, 6};

        Integer[] res = Stream.of(arr1, arr2, arr3)
                .flatMap(Stream::of)
                .toArray(Integer[]::new);

        System.out.println(Arrays.toString(res));
    }

    static void mergeArraysPrimitive() {
        int[] arr1 = {3, 4, 5};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {4, 5, 6};

        int[] res = Stream.of(arr1, arr2, arr3)
                .flatMapToInt(IntStream::of)
                .toArray();

        System.out.println(Arrays.toString(res));
    }

    @SafeVarargs
    static <T> T[] mergedArraysGeneric(T[]... arr) {
        return Stream.of(arr)
                .flatMap(Stream::of)
                .toArray(x -> Arrays.copyOf(arr[0], x));
    }

    static int[] mergedArraysGeneric(int[]... arr) {
        return Stream.of(arr)
                .flatMapToInt(IntStream::of)
                .toArray();
    }

    // program to sort employee id reverse using streams"
    static void sortReverse(){
        employees.stream()
                .sorted(Comparator.comparing(Employee::getId).reversed())
                .toList()
                .forEach(System.out::println);
    }


    public static void main(String[] args) throws InterruptedException {

        sortReverse();
       /* Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {4, 5, 6};
        Integer[] array3 = {7, 8, 9};

        System.out.println(Arrays.toString(mergedArraysGeneric(new int[]{1, 2, 3}, new int[]{4, 5, 6})));*/

        //System.out.println(Arrays.toString(mergedArraysGeneric(array1, array2)));
        //mergeArraysPrimitive();
        //mergeArrays();
        //countWords();
        //System.out.println(getfactorial(5));
        //modifyMap();
        //commonElements();
        //firstNonRepeatedChar();
        //leaderArray();
        //checkPattern();
        //mostCommon();
        //removeDuplicates();
        //getDuplicateOccurrences();
        //get2ndLargestNum();
        //totalSalaryByAge();
        //maxSalaryDepartment();
        //evenGreaterThanN();
        //reverseString();
        //countAlphabets();
        //printNames();
        //generateRandom();
        //filterEmptyStrings();
        /*Main main = new Main();
        main.runThreads();*/
        // getMaxSubArray(new int[]{1,2,3,4,5}, 2);
        //listToMap();
        //topElements();
        //minMax();
        //stringToLength();
        //createStreams();
        //swap();
        // functionalInterfaces();
        //maxSubArray();
        //maxSubArraySum();
        //sort();
        /*reverseArray();
        deleteMapEntries();
        even();
        sum();
        isDivisibleBy3();
        rotateArray();
        System.out.println(factorial(4));
        isPalindrome();
        getCharCount();
        getSumSalariesDept();
        getDuplicates();
        countUniqueWords();
        getDistinctId();*/
        // lambda expression
       /* Shape shape = (int side) -> "this is square String";
        System.out.println(shape.square(2));

        EmployeeInt employee = (Employee em) -> Employee.builder().age(em.getAge()).id(em.getId())
                .name(em.getName()).salary(em.getSalary()).department(em.getDepartment()).build();
        Employee emp = employee.getEmployee(new Employee(1, "zeeshan", 1000, 10, "IT"));
        System.out.println(emp.getSalary()+ " : " + emp.getId());*/

    }
}
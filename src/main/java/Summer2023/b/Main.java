package Summer2023.b;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
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
            new Employee(9, "shaikh", 2000, 40, "HR"),
            new Employee(10, "shaikh", 2000, 30, "HR"),
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

    //program to find max subarray sum
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
    static void sortReverse() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getId).reversed())
                .toList()
                .forEach(System.out::println);
    }

    static void palindromes() {
        String str = "radar";

        boolean res = IntStream.rangeClosed(0, str.length() / 2)
                .mapToObj(c -> (char) c)
                .allMatch(x -> str.charAt(x) == str.charAt(str.length() - x - 1));
        System.out.println(res);
    }

    // program to Check if a list of Strings contains a specific string (ignoring case)
    static void findString() {
        boolean res = Arrays.stream(string.split(" "))
                .anyMatch(x -> x.equalsIgnoreCase("zeeshan"));
        System.out.println(res);
    }

    //Convert a list of integers to a comma-separated string
    static void intToString() {
        String str = Arrays.stream(arr)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));
        System.out.println(str);
    }

    //Find the sum of squares of all odd numbers in a list
    static void squares() {
        Arrays.stream(arr)
                .boxed()
                .filter(x -> x % 2 != 0)
                .map(x -> x * x)
                .toList()
                .forEach(System.out::println);
    }

    //Find the common elements between two lists
    static void common() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);

        list1.stream()
                .filter(x -> list2.stream().anyMatch(y -> Objects.equals(y, x)))
                .toList()
                .forEach(System.out::println);
    }

    //Given a list of strings, create a new list containing only strings that have more than 3 characters, transformed to uppercase.

    static void filterAndTransform() {
        String str = "aa bbb cccc";

        String res = Arrays.stream(str.split(" "))
                .filter(x -> x.length() > 3)
                .map(String::toUpperCase)
                .collect(Collectors.joining(" "));

        System.out.println(res);

    }

    //Given a list of integers, calculate their average.

    static void average() {
        Arrays.stream(arr).average().ifPresent(System.out::println);
    }

    // Given a list of strings, group them by their lengths.
    static void groupByCriteria() {
        String str = "aa ss ddd free rttttt";

        Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(String::length))
                .forEach((k, v) -> System.out.println(k + " = " + v));


    }

    //Given a list of strings, find the most frequently occurring string. If there are multiple such strings, any of them may be returned

    static void frequency() {
        String str = String.valueOf(Arrays.stream(string.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(x -> Math.toIntExact(x.getValue())))
                .stream().findAny());
        System.out.println(str);
    }

    //Given a list of lists of integers, create a flat list of all integers
    static void listOfLists() {
        List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(4, 5, 6, 7, 8));

        list.parallelStream()
                .flatMap(Collection::stream)
                .toList()
                .forEach(System.out::println);
    }

    //Given a list of integers, return a distinct list with each number squared

    static void squared() {
        IntStream.of(arr)
                .boxed()
                .distinct()
                .map(x -> x * x)
                .toList()
                .forEach(System.out::println);
    }

    // Partition a list of numbers into even and odd

    static void partition() {
        Map<Boolean, List<Integer>> map = IntStream.of(arr)
                .boxed()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));

        map.forEach((k, v) -> System.out.println(k + "= " + v));

    }

    //Convert a list of strings into a map where each string is a key, and its length is the value.

    static void convertListToMap() {

        Arrays.stream(string.split(" "))
                .distinct()
                .collect(Collectors.toMap(Function.identity(), String::length))
                .forEach((k, v) -> System.out.println(k + " = " + v));

    }

    // Find the maximum and minimum number from a list of integers.
    static void maxMin() {
        Optional<Integer> max = IntStream.of(arr)
                .boxed()
                .max(Comparator.comparingInt(Integer::intValue));
        Optional<Integer> min = IntStream.of(arr)
                .boxed()
                .min(Comparator.comparingInt(Integer::intValue));
        System.out.println("max = " + max + "\n" + "min = " + min);

    }

    //Given a list of lists of strings, concatenate them into a single list of strings.

    static void concat() {
        List<List<String>> lists = Arrays.asList(Arrays.asList("aa", "bb"), Arrays.asList("cc", "dd"));

        String str = lists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.joining());
        System.out.println(str);
    }

    // Given a list of Person objects with name and age fields, sort them by name, and then by age for those with the same name.

    static void sortNameAge() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge))
                .forEach(System.out::println);

    }

    //Given a list of numbers, find the square root of the first 5 distinct numbers greater than 10.

    static void squareDistinct() {
        IntStream.of(arr)
                .boxed()
                .filter(num -> num > 10)
                .distinct()
                .limit(5)
                .map(Math::sqrt)
                .toList()
                .forEach(System.out::println);
    }

    //Given a list of strings, filter and collect those that start with a certain prefix.
    static void prefix() {
        String str = Stream.of(string.split(" "))
                .filter(x -> x.startsWith("zee"))
                .collect(Collectors.joining(" "));
        System.out.println(str);
    }

    //Calculate the sum of squares of positive numbers from a list of integers.
    static void sumOfSquares() {
        int sum = IntStream.of(arr)
                .boxed()
                .filter(x -> x > 0)
                .map(x -> x * x)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
    }

    //Join a list of strings into a single string with a comma delimiter.
    static void joinListOfStrings() {
        String res = Stream.of(string.split(" "))
                .collect(Collectors.joining(" , "));
        System.out.println(res);
    }

    //Count the number of strings in a list that have a length greater than a given threshold.
    static void threshold() {
        long res = Stream.of(string.split(" "))
                .filter(x -> x.length() > 6)
                .count();
        System.out.println(res);
    }

    //Given a list of integers, return a list of squares without duplicates.
    static void withoutDuplicates() {
        IntStream.of(arr)
                .boxed()
                .distinct()
                .map(x -> x * x)
                .toList()
                .forEach(System.out::println);

    }

    //Group a list of Person objects first by their city and then by their age.
    static void group() {
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.groupingBy(Employee::getAge)))
                .forEach((department, ageMap) -> {
                    System.out.println(department + " = ");
                    ageMap.forEach((age, employeeList) -> System.out.println("\t" + age + " = " + employeeList));
                });
    }

    //Retrieve the top 3 longest strings from a list.
    static void top3() {
        Stream.of(string.split(" "))
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    //check if a number is prime
    static void primeNums() {
        int num = 3;

        boolean res = IntStream.rangeClosed(2, (int) Math.sqrt(num))
                .boxed()
                .noneMatch(x -> num % x == 0);
        System.out.println(res);
    }

    //Given a stream of numbers, calculate the sum of the square roots of the unique even numbers.
    static void sqrt() {
        double res = Arrays.stream(arr)
                .boxed()
                .filter(n -> n % 2 == 0)
                .distinct()
                .mapToDouble(Math::sqrt)
                .sum();
        System.out.println(res);
    }

    //Compute both the average and sum of a list of numbers.
    static void avgSum() {
        DoubleSummaryStatistics summaryStatistics = IntStream.of(arr)
                .boxed()
                .collect(Collectors.summarizingDouble(x -> x));

        double sum = summaryStatistics.getSum();
        double avg = summaryStatistics.getAverage();
        System.out.println(sum);
        System.out.println(avg);
    }

    //Print each element of the stream as it's processed, without altering the final result.
    static void process() {
        Arrays.stream(string.split(" "))
                .peek(System.out::println)
                .map(String::toUpperCase)
                .toList()
                .forEach(System.out::println);
    }

    //Given a list of Employee objects, compute the total salary for a specific department.
    static void totalSalaryByDept() {
        double totalSalary = employees.stream()
                .filter(e -> "IT".equals(e.getDepartment()))
                .map(Employee::getSalary)
                .reduce(0L, Long::sum);
        System.out.println(totalSalary);

    }

    /**
     * Generates a stream of Fibonacci numbers using the Stream API.
     *
     * <p>{@code Stream.iterate(...)}: This method is used to create an infinite stream where each next element is
     * generated based on the previous one.</p>
     *
     * <p><b>Initial Value {@code new long[]{0, 1}}</b>: This is the seed or starting value of the stream. It's an array
     * of two long numbers representing the first two numbers in the Fibonacci sequence (0 and 1).</p>
     *
     * <p><b>Lambda Expression {@code p -> new long[]{p[1], p[0] + p[1]}}</b>: This is the function that produces the
     * next value in the stream based on the current value.
     * Here, {@code p} represents the current pair of Fibonacci numbers in the stream. For each pair:
     * <ul>
     *   <li>{@code p[1]} is the second number of the pair, and it will become the first number of the next pair.</li>
     *   <li>{@code p[0] + p[1]} calculates the next Fibonacci number.</li>
     * </ul>
     * Therefore, given a pair like (a, b), the next pair produced by this lambda function will be (b, a + b).</p>
     *
     * <p>{@code .map(p -> p[0])}: This step transforms the stream of pairs to a stream of single numbers. It extracts
     * the first number from each pair (which is a Fibonacci number) to produce the next number in the sequence.</p>
     */
    static void fibonacci() {
        Stream.iterate(new long[]{0, 1}, p -> new long[]{p[1], p[0] + p[1]})
                .map(p -> p[0])
                .limit(10)
                .forEach(System.out::println);
    }

    /**
     * Group employees by department, and within each department group by salary bands
     */
    static void advGrouping() {
        Map<String, Map<String, List<Employee>>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(e -> {
                    if (e.getSalary() < 2000) return "band 1";
                    if (e.getSalary() > 2000) return "band 2";
                    else return "band 3";
                })));

        map.forEach(
                (dept, band) -> {
                    System.out.println(dept + " : ");
                    band.forEach(
                            (band1, emp) -> System.out.println("\t" + band1 + " = " + emp));
                }
        );
    }

    //Reusing Streams
    static void reuse() {
        Supplier<Stream<String>> supplier = () -> Arrays.stream(string.split(" "));
        supplier.get().forEach(System.out::println);
        boolean res = supplier.get().anyMatch("zeeshan"::equals);
        System.out.println(res);
    }

    interface Shapes {
        int rectangle(int a, int b);

        default int square(int side) {
            return side * side;
        }
    }

    // Given two lists, find elements that are in the first list but not in the second.
    static void diff() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(2, 3, 4, 5, 6);

        list1.stream()
                .filter(x -> !list2.contains(x))
                .toList()
                .forEach(System.out::println);
    }

    //Group employees by department, then further by those earning above and below a certain threshold.
    static void groupAnd() {
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.partitioningBy(e -> e.getSalary() > 2000)))
                .forEach((k, v) -> {
                    System.out.println(k + " = ");
                    v.forEach((k1, v1) -> System.out.println(k1 + " = " + v1));
                });
    }

    //Create a map where the key is an employee's name, and the value is their salary after a raise.
    // Only include those with a salary below a certain threshold.
    static void SalaryThreshold() {
        employees.stream()
                .filter(e -> e.getSalary() < 2000)
                .collect(Collectors.toMap(Employee::getName, e -> e.getSalary() * 1.1, (k, v) -> k))//merge function
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }

    //Compute the sum of salaries for each department, but only for employees who have been with the company for more than 5 years.
    static void moreThan() {
        employees.stream()
                .filter(x -> x.getAge() > 30)
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingLong(Employee::getSalary)))
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }

    //Find duplicate strings in a list.
    static void duplicatesInString() {
        List<String> strings = List.of("a", "b", "c", "a", "b", "c", "d");
        strings.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

    }

    public static void main(String[] args) throws InterruptedException {
        //duplicatesInString();
        //moreThan();
        //SalaryThreshold();
        //groupAnd();
        //diff();
        /*Shapes shapes = (a, b) -> (a * b);
        System.out.println(shapes.rectangle(3, 2));
        System.out.println(shapes.square(5));*/
        //reuse();
        //advGrouping();
        //fibonacci();
        //totalSalaryByDept();
        //process();
        //avgSum();
        //sqrt();
        //primeNums();
        //top3();
        //group();
        //withoutDuplicates();
        //threshold();
        //joinListOfStrings();
        //sumOfSquares();
        //prefix();
        //squareDistinct();
        //sortNameAge();
        //concat();
        //minMax();
        //convertListToMap();
        //partition();
        //squared();
        //listOfLists();
        //frequency();
        //groupByCriteria();
        // average();
        //filterAndTransform();
        //common();
        //squares();
        //intToString();
        // findString();
        //palindromes();
        //sortReverse();
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
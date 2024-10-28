package winter2024;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Lab {

    public static void main(String[] args) throws IOException {

        // 1. Singleton Pattern with Double-Checked Locking
        MySingleton singleton = MySingleton.getInstance();
        singleton.doSomething();

        // 2. Singleton using an Enum
        SingletonEnum.INSTANCE.doSomething();

        // 3. Find two indices in an array that add up to a target
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));

        // 4. Count words in a sentence using Streams
        countWordsUsingStreams("hello world hello");

        // 5. Calculate factorial using recursion
        System.out.println(factorial(5));

        // 6. Rotate an array to the left
        int[] rotatedLeft = rotateArrayLeft(new int[]{1, 2, 3, 4, 5}, 2);
        System.out.println(Arrays.toString(rotatedLeft));

        // 7. Rotate an array to the right
        int[] rotatedRight = rotateArrayRight(new int[]{1, 2, 3, 4, 5}, 2);
        System.out.println(Arrays.toString(rotatedRight));

        // 8. Reverse a string without using a temporary variable
        System.out.println(reverseStringWithoutTemp("hello"));

        // 9. Find common elements between two arrays
        Set<Integer> commonElements = commonElements(new int[]{1, 2, 3}, new int[]{3, 4, 5});
        System.out.println(commonElements);

        // 10. Write data to an Excel file using Apache POI
        apachePoi();

        // 11. Get the first non-repeated character in a string
        getFirstNonRepeatedChar("swiss");

        // 12. Implement an immutable and thread-safe class
        ImmutablePerson person = new ImmutablePerson(1, "Zeeshan");
        System.out.println(person.getName());

        // 13. Find the leader elements in an array
        System.out.println(findLeaders(new int[]{16, 17, 4, 3, 5, 2}));

        // 14. Find the most common element in an array
        System.out.println(mostCommonElement(new int[]{1, 2, 3, 2, 4, 2, 5}));

        // 15. Remove duplicates from a list of integers
        System.out.println(removeDuplicates(Arrays.asList(1, 2, 3, 3, 4, 5, 5)));

        // 16. Remove duplicate words from a string
        System.out.println(removeDuplicateWords("hello world hello universe"));

        // 17. Reverse the alphabets in a string using Streams
        System.out.println(reverseAlphabets("abcdef"));

        // 18. Find the second largest element in a list
        System.out.println(findSecondLargest(Arrays.asList(10, 20, 30, 40, 50)));

        // 19. Count the occurrences of each alphabet in a string
        countAlphabets("hello world");

        // 20. Count the occurrences of each alphabet using Streams
        countAlphabetsUsingStreams("hello world");

        // 21. Reverse a string using Streams
        System.out.println(reverseStringUsingStreams("hello"));

        // 22. Sort employee IDs in descending order using Streams
        System.out.println(sortEmployeeIdsDesc(Arrays.asList(1, 2, 3, 4, 5)));

        // 23. Find the average salary of employees using Streams
        System.out.println(findAverageSalary(Arrays.asList(BigDecimal.valueOf(1000), BigDecimal.valueOf(2000), BigDecimal.valueOf(3000))));

        // 24. Find the maximum salary of employees using Streams
        System.out.println(findMaxSalary(Arrays.asList(BigDecimal.valueOf(1000), BigDecimal.valueOf(2000), BigDecimal.valueOf(3000))));

        // 25. Sort employees by salary using Streams
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", BigDecimal.valueOf(5000)),
                new Employee(2, "Bob", BigDecimal.valueOf(3000))
        );

        System.out.println("Sorted employees by salary: " + sortEmployeesBySalary(employees));


        // 26. Implement a foreach method for a HashMap using Java 8 features
        Map<Integer, String> map = Map.of(1, "One", 2, "Two", 3, "Three");
        foreachHashMap(map);

        // 27. Sort employees by name using comparators
        System.out.println(sortEmployeesByName(employees));

        // 28. Sort employees by salary using comparators
        System.out.println(sortEmployeesBySalaryComparator(employees));

        // 29. Check for equality and hash codes for objects
        Employee emp1 = new Employee(1, "Alice", BigDecimal.valueOf(5000));
        Employee emp2 = new Employee(1, "Alice", BigDecimal.valueOf(5000));
        checkEqualityAndHashCodes(emp1, emp2);

        // 30. Create a thread using `Thread` class
        Thread thread = new MyThread();
        thread.start();

        // 31. Create a thread using `Runnable` interface
        Thread runnableThread = new Thread(new MyRunnable());
        runnableThread.start();

        // 32. Use a lambda expression to print a greeting message
        lambdaGreeting();

        // 33. Delete or merge entries in a HashMap
        Map<Integer, String> mergeMap = new HashMap<>(Map.of(1, "Value1", 2, "Value2"));
        mergeHashMapEntries(mergeMap);

        // 34. Iterate over a HashMap using entry set
        iterateHashMap(Map.of(1, "One", 2, "Two", 3, "Three"));

        // 35. Check if a string is a palindrome
        System.out.println(isPalindrome("radar"));

        // 36. Find the maximum number in a list using Streams
        System.out.println(findMaxNumber(Arrays.asList(10, 20, 30, 40, 50)));

        // 37. Create a parallel stream and map numbers to their squares
        System.out.println(squareNumbers(Arrays.asList(1, 2, 3, 4, 5)));

        // 38. Print a name 10 times using Streams
        printNameNTimes("Zeeshan", 10);

        // 39. Generate random integers between 100 and 200 using Streams
        generateRandomIntegers(10);

        // 40. Join two lists using Streams
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        System.out.println(joinLists(list1, list2));

        // 41. Join two String-based maps
        Map<String, String> map1 = Map.of("A", "Apple", "B", "Banana");
        Map<String, String> map2 = Map.of("B", "Blueberry", "C", "Cherry");
        System.out.println(joinStringMaps(map1, map2));

        // 42. Join two Integer-based maps
        Map<Integer, Integer> intMap1 = Map.of(1, 100, 2, 200);
        Map<Integer, Integer> intMap2 = Map.of(2, 300, 3, 400);
        System.out.println(joinIntegerMaps(intMap1, intMap2));

        // 43. Find and print duplicate occurrences in an integer array
        System.out.println("// 1. Find duplicate occurrences in an integer array");
        Lab.getDuplicateOccurrencesStreams(new int[]{1, 2, 4, 4, 2, 5});

        // 44. Find and print duplicate occurrences in a string array
        System.out.println("\n// 2. Find duplicate occurrences in a string array");
        Lab.getDuplicateOccurrencesOfStringsUsingStream();
    }

    // 43. Method to find duplicate occurrences in an integer array using streams
    static void getDuplicateOccurrencesStreams(int[] arr) {
        Map<Integer, Long> map = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        map.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    // 44. Method to find duplicate occurrences in string arrays and lists using streams
    static void getDuplicateOccurrencesOfStringsUsingStream() {
        // Example 1: Find duplicates in a string array
        System.out.println("String Array:");
        String[] strings = new String[]{"zeeshan", "akram", "shaikh", "zeeshan"};

        Arrays.stream(strings)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getKey().equals("zeeshan"))
                .filter(x -> x.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((k, v) -> System.out.println(k + " = " + v));

        // Example 2: Find duplicates in a list of strings
        List<String> stringList = Arrays.asList("test", "akram", "shaikh", "test", "shaikh", "test");
        System.out.println("\nList of Strings:");

        stringList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }

    // 1. Implement a Singleton Pattern with Double-Checked Locking
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
            System.out.println("Singleton action performed!");
        }
    }

    // 2. Implement a Singleton using an Enum
    public enum SingletonEnum {
        INSTANCE;

        public void doSomething() {
            System.out.println("Singleton enum action performed!");
        }
    }

    // 3. Find two indices in an array such that their values add up to a target
    static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return null;
    }

    // 4. Count words in a sentence using Streams
    static void countWordsUsingStreams(String sentence) {
        Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }

    // 5. Calculate factorial using recursion
    static int factorial(int num) {
        return num <= 1 ? 1 : num * factorial(num - 1);
    }

    // 6. Rotate an array to the left
    static int[] rotateArrayLeft(int[] arr, int d) {
        int length = arr.length;
        int[] rotated = new int[length];
        for (int i = 0; i < length; i++) {
            rotated[i] = arr[(i + d) % length];
        }
        return rotated;
    }

    // 7. Rotate an array to the right
    static int[] rotateArrayRight(int[] arr, int d) {
        int length = arr.length;
        int[] rotated = new int[length];
        for (int i = 0; i < length; i++) {
            rotated[(i + d) % length] = arr[i];
        }
        return rotated;
    }

    // 8. Reverse a string without using a temporary variable
    static String reverseStringWithoutTemp(String sentence) {
        char[] chars = sentence.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left] ^= chars[right];
            left++;
            right--;
        }
        return new String(chars);
    }

    // 9. Find common elements between two arrays
    static Set<Integer> commonElements(int[] arr1, int[] arr2) {
        Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        return Arrays.stream(arr2)
                .filter(set1::contains)
                .boxed()
                .collect(Collectors.toSet());
    }

    // 10. Write data to an Excel file using Apache POI
    static void apachePoi() throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("SampleSheet");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("id");
            header.createCell(1).setCellValue("name");
            Row data = sheet.createRow(1);
            data.createCell(0).setCellValue("1");
            data.createCell(1).setCellValue("zeeshan");

            try (FileOutputStream outputStream = new FileOutputStream("SampleSheet.xlsx")) {
                workbook.write(outputStream);
            }
        }
    }

    // 11. Get the first non-repeated character in a string
    static void getFirstNonRepeatedChar(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .ifPresent(entry -> System.out.println("First non-repeated character: " + entry.getKey()));
    }

    // 12. Implement an immutable and thread-safe class
    static final class ImmutablePerson {
        private final int id;
        private final String name;

        public ImmutablePerson(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    // 13. Find the leader elements in an array
    static List<Integer> findLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int max = arr[arr.length - 1];
        leaders.add(max);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                leaders.add(max);
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }

    // 14. Find the most common element in an array
    static int mostCommonElement(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        return frequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(-1);
    }

    // 15. Remove duplicates from a list of integers
    static List<Integer> removeDuplicates(List<Integer> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    // 16. Remove duplicate words from a string
    static String removeDuplicateWords(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .distinct()
                .collect(Collectors.joining(" "));
    }

    // 17. Reverse the alphabets in a string using Streams
    static String reverseAlphabets(String str) {
        return IntStream.rangeClosed(1, str.length())
                .mapToObj(i -> String.valueOf(str.charAt(str.length() - i)))
                .collect(Collectors.joining());
    }

    // 18. Find the second largest element in a list
    static int findSecondLargest(List<Integer> list) {
        return list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(-1);
    }

    // 19. Count the occurrences of each alphabet in a string
    static void countAlphabets(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        frequencyMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    // 20. Count the occurrences of each alphabet using Streams
    static void countAlphabetsUsingStreams(String str) {
        Map<Character, Long> frequencyMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        frequencyMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    // 21. Reverse a string using Streams
    static String reverseStringUsingStreams(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // 22. Sort employee IDs in descending order using Streams
    static List<Integer> sortEmployeeIdsDesc(List<Integer> ids) {
        return ids.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    // 23. Find the average salary of employees using Streams
    static BigDecimal findAverageSalary(List<BigDecimal> salaries) {
        return salaries.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(salaries.size()), RoundingMode.HALF_UP);
    }

    // 24. Find the maximum salary of employees using Streams
    static BigDecimal findMaxSalary(List<BigDecimal> salaries) {
        return salaries.stream().max(BigDecimal::compareTo).orElse(BigDecimal.ZERO);
    }

    // 25. Sort employees by salary using Streams
    static List<Employee> sortEmployeesBySalary(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
    }

    // 26. Implement a foreach method for a HashMap using Java 8 features
    static void foreachHashMap(Map<Integer, String> map) {
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    // 27. Sort employees by name using comparators
    static List<Employee> sortEmployeesByName(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
    }

    // 28. Sort employees by salary using comparators
    static List<Employee> sortEmployeesBySalaryComparator(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
    }

    // 29. Check for equality and hash codes for objects
    static void checkEqualityAndHashCodes(Employee emp1, Employee emp2) {
        System.out.println(emp1.equals(emp2));
        System.out.println(emp1.hashCode() == emp2.hashCode());
    }

    // 30. Create a thread using `Thread` class
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread is running");
        }
    }

    // 31. Create a thread using `Runnable` interface
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Runnable is running");
        }
    }

    // 32. Use a lambda expression to print a greeting message
    static void lambdaGreeting() {
        Greetings greeting = name -> System.out.println("Hello, " + name);
        greeting.sayHello("Zeeshan");
    }

    interface Greetings {
        void sayHello(String name);
    }

    // 33. Delete or merge entries in a HashMap
    static void mergeHashMapEntries(Map<Integer, String> map) {
        map.merge(1, "newValue", String::concat);
        System.out.println(map);
    }

    // 34. Iterate over a HashMap using entry set
    static void iterateHashMap(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // 35. Check if a string is a palindrome
    static boolean isPalindrome(String str) {
        return IntStream.range(0, str.length() / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1));
    }

    // 36. Find the maximum number in a list using Streams
    static int findMaxNumber(List<Integer> list) {
        return list.stream().max(Integer::compare).orElse(-1);
    }

    // 37. Create a parallel stream and map numbers to their squares
    static List<Integer> squareNumbers(List<Integer> numbers) {
        return numbers.parallelStream().map(n -> n * n).collect(Collectors.toList());
    }

    // 38. Print a name 10 times using Streams
    static void printNameNTimes(String name, int n) {
        IntStream.range(0, n).forEach(i -> System.out.println(name));
    }

    // 39. Generate random integers between 100 and 200 using Streams
    static void generateRandomIntegers(int count) {
        new Random().ints(100, 201).limit(count).forEach(System.out::println);
    }

    // 40. Join two lists using Streams
    static List<Integer> joinLists(List<Integer> list1, List<Integer> list2) {
        return Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
    }

    // 41. Join two String-based maps
    static Map<String, String> joinStringMaps(Map<String, String> map1, Map<String, String> map2) {
        return Stream.of(map1, map2)
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1 + ", " + v2));
    }

    // 42. Join two Integer-based maps
    static Map<Integer, Integer> joinIntegerMaps(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
        return Stream.of(map1, map2)
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum));
    }

    // Class for Employee used in certain methods
    static class Employee {
        private final int id;
        private final String name;
        private final BigDecimal salary;

        public Employee(int id, String name, BigDecimal salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public BigDecimal getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}

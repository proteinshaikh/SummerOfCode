package Summer2023.a;

import lombok.Builder;
import lombok.Data;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    static class ExThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.print(i + " ");
            }
            System.out.println("Exthread: " + Thread.currentThread().getId());
        }
    }

    static class RunThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.print(i + " ");
            }
            System.out.println("RunThread: " + Thread.currentThread().getId());
        }
    }

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

    /*
    Bill Pugh Singleton (Using Inner Static Helper Class)
    */

    static class MySingleton2 {

        private MySingleton2() {
        }

        public static MySingleton2 getInstance() {
            return SingletonHelper.INSTANCE;
        }

        private static class SingletonHelper {
            private static final MySingleton2 INSTANCE = new MySingleton2();
        }
    }


    //Singleton using enum
    public enum Singleton {
        INSTANCE;

        public void doSomething() {
            System.out.println("something done by singleton enum!");
        }
    }

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

    static int countWords(String sentence) {
        String[] strings = sentence.split(" ");
        int count = 0;
        for (String s : strings) {
            count++;
        }
        return count;
    }

    static int countWordsUsingStreams(String sentence) {
        String[] strings = sentence.split(" ");
        return Math.toIntExact(Arrays.stream(strings).count());
    }

    static void countWordsIgnoreCase(String sentence) {

        Map<String, Long> map = Arrays.stream(sentence.toLowerCase().split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.forEach((key, value) -> System.out.println(key + " " + value));
    }


    static int factorial(int num) {
        if (num <= 1) return 1;

        return num * factorial(num - 1);
    }

    //rotate left
    static int[] rotateArrayLeft(int[] arr, int d) {
        int length = arr.length;
        int[] temp = new int[length];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[(i + d) % arr.length];
        }
        return temp;
    }

    //rotate right
    static int[] rotateArrayRight(int[] arr, int d) {
        int length = arr.length;
        int[] temp = new int[length];

        for (int i = 0; i < arr.length; i++) {
            temp[(i + d) % length] = arr[i];
        }
        return temp;
    }

    static String reverseStringWithoutTemp(String sentence) {
        char[] chars = sentence.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            chars[left] = (char) (chars[left] ^ chars[right]);
            chars[right] = (char) (chars[left] ^ chars[right]);
            chars[left] = (char) (chars[left] ^ chars[right]);

            left++;
            right--;
        }
        return new String(chars);
    }

    interface Greetings {
        void sayHello(String name);
    }

    static Set<Integer> commonElements(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> common = new HashSet<>();
        for (int j : arr1) {
            set.add(j);
        }

        for (int j : arr2) {
            if (set.contains(j)) {
                common.add(j);
            }
        }
        return common;
    }

    static void apachePoi() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("SampleSheet");

        // Create header row
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("id");
        row.createCell(1).setCellValue("name");

        // Set Cell value
        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("1");
        row1.createCell(1).setCellValue("zeeshan");

        //write the output to a file

        try (
                FileOutputStream fileOutputStream = new FileOutputStream("SampleSheet.xlsx")) {
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            workbook.close();
        }
    }

    static void getFirstNonRepeatedChar(String string) {
        char[] chars = string.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char a : chars) {
            if (map.containsKey(a)) {
                map.put(a, map.getOrDefault(a, 0) + 1);
            } else {
                map.put(a, 1);
            }
        }
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (m.getValue() == 1) {
                System.out.println(m.getKey());
                break;
            }
        }
    }

    static final class ImmutabelThreadSafeClass {
        private final int id;
        private final String name;

        public ImmutabelThreadSafeClass(
                int id,
                String name
        ) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }
    }

    static List<Integer> getLeaderArray(int[] arr) {
        int maxFromRight = arr[arr.length - 1];
        List<Integer> resArr = new ArrayList<>();
        resArr.add(maxFromRight);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                maxFromRight = arr[i];
                resArr.add(maxFromRight);
            }
        }
        return resArr;
    }

    static int mostCommonElement(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int j : arr) {
            if (map.containsKey(j)) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            } else {
                map.put(j, 1);
            }
        }

        int max = 1;
        int mostCommonKey = 0;

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > max) {
                max = m.getValue();
                mostCommonKey = m.getKey();
            }
        }
        return mostCommonKey;
    }

    static void removeDuplicatesFromList(List<Integer> list) {

        for (int a : new HashSet<>(list)) {
            System.out.print(a + " ");
        }
    }

    static void removeDuplicateStrings(String string) {
        String[] strings = string.split(" ");

        for (String s : Arrays.stream(strings).distinct().toList()) {
            System.out.print(s + " ");
        }
    }

    static String reverseAlphabetsUsingStreams(String string) {

        return IntStream.rangeClosed(1, string.length())
                .mapToObj(i -> string.charAt(string.length() - i))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) throws IOException {
        System.out.println("scope of beans");
        System.out.println("get 2nd largest num from list");
        System.out.println("total salary of all employees whose age is greater than 30");
        System.out.println("maximum salary of all employees in a department");
        System.out.println("find the first five even numbers greater than 10");
        System.out.println("String reverse");
        System.out.println("read file in sync");
        System.out.println("circuit breaker config");
        System.out.println("prevent clone");
        System.out.println("covariant return types");
        System.out.println("poi");
        System.out.println("count alphabets using streams");
        System.out.println("abstract enums");
        System.out.println("read db data sort");
        System.out.println("streams hub");
        System.out.println("compress string using map");
        System.out.println("Maximum length of contiguous subarray with sum 0");


        System.out.println("reverse alphabets using streams");

        System.out.println(Employee.reverseAlphabetsUsingStreams("hello zeeshan"));
        System.out.println();

        System.out.println("remove duplicates from list of Strings");

        Employee.removeDuplicatesFromList(Arrays.asList(1, 2, 3, 4, 4, 5, 5, 5));
        Employee.removeDuplicateStrings("test test test zee sha sha");
        System.out.println();


        System.out.println("Optional empty list");
        Optional<List<Integer>> optionalList = Optional.of(Collections.emptyList());
        optionalList.flatMap(list -> list.stream().max(Integer::compare)).ifPresent(System.out::println);

        System.out.println("most common element");
        System.out.println(Employee.mostCommonElement(new int[]{1, 2, 2, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5}));


        System.out.println("leader array");
        for (int a : Employee.getLeaderArray(new int[]{16, 17, 4, 3, 5, 2})) {
            System.out.print(a + " ");
        }
        System.out.println();

        System.out.println("immutable threadsafe class"); //DONE

        System.out.println("first non repeated character");
        Employee.getFirstNonRepeatedChar("get first non repeated char");

        System.out.println("apache poi");
        //Employee.apachePoi(); //TODO uncomment while executing apache poi

        System.out.println("find common elements between 2 arrays");
        Set<Integer> set = Employee.commonElements(new int[]{1, 2, 3, 4, 5}, new int[]{5});
        for (int a : set) {
            System.out.print(a + " ");
        }
        System.out.println();

        System.out.println("count the number of occurrences of each alphabet in a sentence using streams");

        String string = "count these alphabets using streams!";

        char[] chars = string.toCharArray();
        Map<Character, Integer> maps = new HashMap<>();
        for (char a : chars) {
            if (maps.containsKey(a)) {
                maps.put(a, (maps.getOrDefault(a, 0) + 1));
            } else {
                maps.put(a, 1);
            }
        }
        maps.forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("3rd highest salary sql");
        String query = "select * from employee where (select distinct salary from employee order by salary desc limit 2, 1";


        System.out.println("sort millions of data from database in batches (know)"); //DONE


        System.out.println("alphabets reverse without temp variable");
        System.out.println(reverseStringWithoutTemp("reverse this without temp!"));


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
        Thread t1 = new ExThread();
        Thread t2 = new ExThread();
        //t1.start(); //TODO uncomment for testing
        //t2.start(); //TODO uncomment for testing

        System.out.println("Threads Runnable");
        Thread r1 = new Thread(new RunThread());
        Thread r2 = new Thread(new RunThread());
        //r1.start(); //TODO uncomment for testing
        //r2.start();//TODO uncomment for testing

        System.out.println("thread safe singleton using executor"); //DONE

        System.out.println("builder"); //DONE
        System.out.println("factory"); //DONE
        System.out.println("two sum");
        for (int a : Objects.requireNonNull(Employee.twoSum(new int[]{1, 2, 3, 4, 5}, 5))) {
            System.out.print(a + " ");
        }
        System.out.println();

        System.out.println("count words using streams");
        System.out.println(Employee.countWords("please count these words"));
        System.out.println(Employee.countWordsUsingStreams("please count these words"));

        System.out.println("Count words using streams ignore case");
        Employee.countWordsIgnoreCase("please count these words Words");
        System.out.println("factorial using recursion");
        System.out.println(Employee.factorial(5));

        System.out.println("rotate array left");
        for (int a : Employee.rotateArrayLeft(new int[]{1, 2, 3, 4, 5}, 2)) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println("rotate array right");
        for (int a : Employee.rotateArrayRight(new int[]{1, 2, 3, 4, 5}, 2)) {
            System.out.print(a + " ");
        }
        System.out.println();

        System.out.println("flatmap");
        int[][] ints = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}};
        Arrays.stream(ints).flatMapToInt(Arrays::stream).forEach(System.out::println);

        System.out.println("lambda exp");
        Greetings greetings = name1 -> System.out.println("hello " + name1);
        greetings.sayHello("zeeshan");

        System.out.println("delete/merge hashmap entries");
        map.remove(1);
        map.forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("iterate hashmap ");

        for (Map.Entry<Integer, Employee> employeeEntry : map.entrySet()) {
            System.out.println(employeeEntry.getKey() + " " + employeeEntry.getValue());
        }

        System.out.println("max number in list using streams");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> maxNum = list.stream().max(Integer::compare);
        maxNum.ifPresent(System.out::println);

        System.out.println("parallel streams");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.parallelStream()
                .map(n -> n * n)
                .toList();
        squares.forEach(System.out::println);
    }
}

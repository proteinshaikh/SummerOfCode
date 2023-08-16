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
import java.util.function.Function;
import java.util.stream.Collectors;

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
        System.out.println("alphabets reverse without temp variable");
        System.out.println(reverseStringWithoutTemp("reverse this without temp!"));
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
        System.out.println("Maximum length of contiguous subarray with sum 0");
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

package Winter2022.g;

import java.util.*;
import java.util.stream.Collectors;

public class Employee implements Comparable<Employee> {


    static int factorial(int num) {
        if (num == 0 || num == 1) return 1;
        return factorial(num - 1) * num;
    }


    private int id;
    private String name;

    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(employee.salary, salary) == 0 && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }

    @Override
    public int compareTo(Employee o) {
        if (id > this.getId()) return 1;
        if (id < this.getId()) return -1;
        return name.compareTo(this.getName());
    }

    public static void main(String[] args) {

        Map<Integer, Employee> map = new HashMap<>();
        List<Employee> list = new ArrayList<>();
        Employee e1 = new Employee(10, "zee", 1000);
        Employee e2 = new Employee(20, "zee", 2000);
        Employee e3 = new Employee(30, "zee", 3000);
        Employee e4 = new Employee(30, "zee", 3000);

        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);

        map.put(1, e1);
        map.put(2, e2);
        map.put(3, e3);
        map.put(3, e4);

        System.out.println("-------------testing distinct id/name using streams------------------------");

        for (Employee e : list.stream().distinct().collect(Collectors.toList())) {
            System.out.println(e.getId() + e.getName() + e.getSalary());
        }

        System.out.println("-------------testing average income using streams------------------------");
        System.out.println("average income = " + list.stream().mapToDouble(x -> x.getSalary()).average());

        System.out.println("-------------testing max salary using streams------------------------");
        System.out.println("max income = " + list.stream().mapToDouble(x -> x.getSalary()).average());

        System.out.println("-------------testing sort student id reverse using streams------------------------");

        for (Employee e : list.stream().sorted(Comparator.comparingInt(Employee::getId).reversed()).collect(Collectors.toList())) {
            System.out.println(e.getId() + e.getName() + e.getSalary());
        }
        System.out.println("-------------testing sort players by goals------------------------");


        for (Map.Entry<Integer, Employee> e : map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList())) {
            System.out.println(e.getKey() + " " + e.getValue().getId());
        }


        System.out.println("-------------testing foreach method in hashmap- new java 8------------------------");
        map.forEach((key, value) -> System.out.println(key + " " + value.id + " " + value.name + " " + value.salary));
        System.out.println("-------------testing comparables------------------------");

        Collections.sort(list);
        for (Employee e : list) {
            System.out.println(e.getId() + e.getName() + e.getSalary());
        }
        System.out.println("-------------testing comparators id------------------------");
        Collections.sort(list, new NameComp());
        for (Employee e : list) {
            System.out.println(e.getId() + e.getName() + e.getSalary());
        }

        System.out.println("-------------testing comparators id------------------------");
        Collections.sort(list, new IdComp());
        for (Employee e : list) {
            System.out.println(e.getId() + e.getName() + e.getSalary());
        }
        System.out.println("-------------testing equals and hashcode------------------------");
        if (e3.hashCode() == e4.hashCode()) {
            System.out.println(true);
        }

        System.out.println("-------------Test ExThread------------------------");
        for (int i = 0; i < 5; i++) {
            new ExThread().start();
        }
        System.out.println("-------------Test Threads Runnable------------------------");
        for (int i = 0; i < 5; i++) {
            new Thread(new RunThread()).start();
        }

        System.out.println("-------------Test builder------------------------");
        //done in test class
        System.out.println("-------------Test factory------------------------");
        //done in factory package
        System.out.println("-------------Test twosum------------------------");
        //done in seperate class
        System.out.println("-------------Test count words------------------------");
        countWords("hello hello zeeshan zeeshan shaikh shaikh shaikh");
        System.out.println("-------------factorial using recursion------------------------");
        System.out.println("factorial of num is : " + factorial(5));
        System.out.println("-------------rotate array------------------------");
        System.out.println("-------------flatmap------------------------");
        for (int n : StringToNumsUsingFlatMap(Arrays.asList("1,2,3", "4,5,6", "7,8,9"))) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("-------------lambda exp------------------------");
    }

    static void countWords(String str) {
        String[] strings = str.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i])) {
                map.put(strings[i], map.getOrDefault(strings[i], 0) + 1);
            } else {
                map.put(strings[i], 1);
            }
        }

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.print(m.getKey() + ":" + m.getValue() + " ");
        }
        System.out.println();
    }

    static List<Integer> StringToNumsUsingFlatMap(List<String> list) {
        return list.stream()
                .flatMap(x -> Arrays.stream(x.split(",")))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

class NameComp implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class IdComp implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getId() - o2.getId();
    }
}

class ExThread extends Thread {
    @Override
    public void run() {
        System.out.println("exthread " + Thread.currentThread().getId());
    }
}


class RunThread implements Runnable {

    @Override
    public void run() {
        System.out.println("runthread " + Thread.currentThread().getId());
    }
}

class TSingleton {
    private static volatile TSingleton instance; //volatile works fine only after java 5

    private TSingleton() {

    }

    public static TSingleton getInstance() {
        if (instance == null) {
            synchronized (TSingleton.class) {
                if (instance == null) {
                    instance = new TSingleton();
                }
            }
        }
        return instance;
    }

    public void doSomething() {

    }

}

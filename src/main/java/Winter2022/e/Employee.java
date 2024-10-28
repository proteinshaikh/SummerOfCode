package Winter2022.e;


import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee implements Comparable<Employee> {

    static int[] twosum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
                map.put(arr[i], i);
            }
        }
        return null;
    }

    static Map<String, Integer> countWords(String str) {
        String[] strarr = str.split("\\s+");

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strarr.length; i++) {
            if (map.containsKey(strarr[i])) {
                map.put(strarr[i], map.getOrDefault(strarr[i], 0) + 1);
            } else {
                map.put(strarr[i], 1);
            }
        }
        return map;
    }

    static int factorial(int num) {
        if (num == 0 || num == 1) return 1;
        else return num * factorial(num - 1);
    }

    static int[] rotateArr(int[] arr, int d) {
        int len = arr.length;
        int[] temp = new int[len];

        for (int i = 0; i < len; i++) {
            temp[i] = arr[(i + d) % len];
        }
        return temp;
    }

    private int id;
    private String name;

    private double income;

    public Employee(int id, String name, double income) {
        this.id = id;
        this.name = name;
        this.income = income;
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

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    @Override
    public int compareTo(@NonNull Employee o) {
        if (id > o.getId()) return 1;
        if (id < o.getId()) return -1;
        else return name.compareTo(o.getName());
    }

    public static void main(String[] args) {
        Map<Integer, Employee> map = new HashMap<>();

        Employee e1 = new Employee(10, "zee", 1000);
        Employee e2 = new Employee(20, "sha", 2000);
        Employee e3 = new Employee(30, "akr", 3000);
        map.put(1, e1);
        map.put(2, e2);
        map.put(3, e3);
        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);

        System.out.println("-------------testing average income using streams------------------------");
        double avgincome = list.stream().mapToDouble(x -> x.getIncome()).average().orElse(0.0);
        System.out.println("average incomeis " + avgincome);
        System.out.println("-------------testing max salary using streams------------------------");
        double maxsalary = list.stream().mapToDouble(x -> x.getIncome()).max().orElseThrow(IllegalArgumentException::new);
        System.out.println("max salray is " + maxsalary);

        System.out.println("-------------testing sort student id reverse using streams------------------------");
        List<Employee> emps = list.stream().sorted(Comparator.comparingInt(Employee::getId).reversed()).collect(Collectors.toList());
        for (Employee e : emps) {
            System.out.println(e.getId() + " : " + e.getName() + " : " + e.getIncome());
        }

        System.out.println("-------------testing comparables------------------------");
        Collections.sort(list);
        for (Employee e : list) {
            System.out.println(e.getId() + " : " + e.getName() + " : " + e.getIncome());
        }

        System.out.println("-------------testing comparators name------------------------");
        Collections.sort(list, new NameComp());
        for (Employee e : list) {
            System.out.println(e.getId() + " : " + e.getName() + " : " + e.getIncome());
        }

        System.out.println("-------------testing comparators id------------------------");
        Collections.sort(list, new IdComp());
        for (Employee e : list) {
            System.out.println(e.getId() + " : " + e.getName() + " : " + e.getIncome());
        }
        System.out.println("-------------Test Threads------------------------");
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new RunThread());
            thread.start();
            ExThread exThread = new ExThread();
            exThread.start();
        }
        System.out.println("-------------Test thread safe singleton------------------------");

        System.out.println("-------------Test builder------------------------");
        User user = new User.UserBuilder(1, "zee").build();
        System.out.println(user.getId() + user.getName());

        System.out.println("-------------Test twosum------------------------");
        int[] ints = twosum(new int[]{1, 2, 3, 4, 5}, 7);
        for (int a : ints) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println("-------------Test count words------------------------");
        Map<String, Integer> countMap = countWords("hello hello zeeshan shaikh shaikh");
        for (Map.Entry<String, Integer> m : countMap.entrySet()) {
            System.out.println(m.getKey() + " : " + m.getValue());
        }
        System.out.println("-------------factorial using recursion------------------------");
        System.out.println("factorial : " + factorial(7));
        System.out.println("-------------rotate array------------------------");
        for (int a : rotateArr(new int[]{1, 2, 3, 4, 5}, 2)) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println("-------------flatmap------------------------");
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
        List<Integer> flat = lists.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        for (int a : flat) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println("-------------lambda exp------------------------");
        Company company = x -> x * x;
        System.out.println(company.employee(2500));


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
        System.out.println("Exthread " + Thread.currentThread().getId());
    }


}

class RunThread implements Runnable {

    @Override
    public void run() {
        System.out.println("RunThread " + Thread.currentThread().getId());
    }

}


interface Company {
    int employee(int salary);
}

interface EmpInterface {
    int employee(Employee employee);
}

class User {
    private final int id;
    private final String name;

    public User(UserBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    static class UserBuilder {
        private final int id;
        private final String name;

        public UserBuilder(int id, String name) {
            this.id = id;
            this.name = name;
        }


        User build() {
            return new User(this);
        }

    }
}


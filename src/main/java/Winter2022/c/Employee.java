package Winter2022.c;


import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee implements Comparable<Employee> {

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
        if (o == null) return false;
        if (getClass() != o.getClass()) ;
        if (!(o instanceof Employee)) return false;
        Employee e = (Employee) o;
        return name.equals(e.getName()) || id == e.getId() || salary == e.getSalary();
    }

    @Override
    public int hashCode() {
        int res = 17;
        res = 31 * res + id;
        res = 31 * res + ((name != null) ? name.hashCode() : 0);
        return res;
    }


    @Override
    public int compareTo(@NonNull Employee o) {
        if (id > o.getId()) return 1;
        if (id < o.getId()) return -1;
        else return name.compareTo(o.getName());
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee(10, "zee", 1000);
        Employee e2 = new Employee(20, "akr", 2000);
        Employee e3 = new Employee(30, "sha", 3000);
        Employee e4 = new Employee(40, "tst", 4000);
        Employee e5 = new Employee(40, "tst", 4000);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        Map<Integer, Employee> map = new HashMap<>();
        map.put(1, e1);
        map.put(2, e2);
        map.put(3, e3);
        map.put(4, e4);
        map.put(5, e5);

        System.out.println("-------------testing average income using streams------------------------");

        double avgincome = employees.stream().mapToDouble(x -> x.salary).average().orElse(0.0);
        System.out.println("average salary is : " + avgincome);

        System.out.println("-------------testing max salary using streams------------------------");

        double maxsalary = employees.stream().mapToDouble(x -> x.salary).average().orElse(0.0);
        System.out.println("average salary: " + avgincome);


        System.out.println("-------------testing sort student id reverse using streams------------------------");

        List<Employee> sortedById = employees.stream().sorted(Comparator.comparingInt(Employee::getId).reversed()).collect(Collectors.toList());
        for (Employee e : sortedById) {
            System.out.println(e.getId() + " : " + e.getName() + " : " + e.getSalary());
        }

        System.out.println("-------------testing comparables------------------------");

        Collections.sort(employees);
        for (Employee e : employees) {
            System.out.println(e.getId() + " : " + e.getName() + " : " + e.getSalary());
        }

        System.out.println("-------------testing comparators name------------------------");
        Collections.sort(employees, new Namecomp());
        for (Employee e : employees) {
            System.out.println(e.getId() + " : " + e.getName() + " : " + e.getSalary());
        }

        System.out.println("-------------testing comparators id------------------------");
        Collections.sort(employees, new IdComp());
        for (Employee e : employees) {
            System.out.println(e.getId() + " : " + e.getName() + " : " + e.getSalary());
        }
        System.out.println("-------------Test Threads------------------------");

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new RunThread());
            thread.start();
        }

        for (int i = 0; i < 5; i++) {
            Exthread exthread = new Exthread();
            exthread.start();
        }
    }
}


class IdComp implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getId() - o2.getId();
    }
}

class Namecomp implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class Exthread extends Thread {
    @Override
    public void run() {
        System.out.println("exthread running : " + Thread.currentThread().getId());
    }
}

class RunThread implements Runnable {

    @Override
    public void run() {
        System.out.println("runthread running : " + Thread.currentThread().getId());
    }
}
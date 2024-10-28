package Winter2022.f;


import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Person implements Comparable<Person> {

    static int factorial(int num) {
        if (num == 0 || num == 1) return 1;
        else return num * factorial(num - 1);
    }

    static int[] rotateArr(int[] arr, int d) {
        int len = arr.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[i] = arr[(d + i) % len];
        }
        return temp;
    }

    public static void main(String[] args) {

        Map<Integer, Person> map = new HashMap<>();
        Person p1 = new Person(10, "zee", 1000);
        Person p2 = new Person(20, "sha", 2000);
        Person p3 = new Person(20, "akr", 2000);
        Person p4 = new Person(20, "akr", 2000);
        map.put(1, p1);
        map.put(2, p2);
        map.put(3, p3);

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        System.out.println("-------------testing distinct id/name using streams------------------------");
        List<Integer> list1 = list.stream().map(x -> x.getId()).distinct().collect(Collectors.toList());
        for (int a : list1) {
            System.out.print(a + " ");
        }
        System.out.println();
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 6, 6, 5, 5);
        List<Integer> integersRes = integers.stream().distinct().collect(Collectors.toList());
        for (int a : integersRes) {
            System.out.print(a + "");
        }
        System.out.println();
        List<String> strings = Arrays.asList("zee", "zee", "sha", "sha", "zee");
        List<String> stringsRes = strings.stream().distinct().collect(Collectors.toList());
        for (String s : stringsRes) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("-------------testing average income using streams------------------------");
        double avgincome = list.stream().mapToDouble(x -> x.getIncome()).average().orElseThrow(IllegalArgumentException::new);
        System.out.println("average income : " + avgincome);
        System.out.println("-------------testing max salary using streams------------------------");
        double maxincome = list.stream().mapToDouble(x -> x.getIncome()).max().orElseThrow(IllegalArgumentException::new);
        System.out.println("average income : " + maxincome);
        System.out.println("-------------testing sort student id reverse using streams------------------------");

        List<Map.Entry<Integer, Person>> sortedList = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
        for (Map.Entry<Integer, Person> m : sortedList) {
            System.out.println(m.getKey() + " " + m.getValue().getId());
        }
        System.out.println("-------------testing comparables------------------------");
        Collections.sort(list);
        for (Person p : list) {
            System.out.println(p.getId() + " : " + p.getName() + " : " + p.getIncome());
        }
        System.out.println("-------------testing comparators name------------------------");
        Collections.sort(list, new NameComp());
        for (Person p : list) {
            System.out.println(p.getId() + " : " + p.getName() + " : " + p.getIncome());
        }
        System.out.println("-------------testing comparators id------------------------");
        Collections.sort(list, new IdComp());
        for (Person p : list) {
            System.out.println(p.getId() + " : " + p.getName() + " : " + p.getIncome());
        }
        System.out.println("-------------testing equals and hashcode------------------------");
        if (p3.hashCode() == p4.hashCode())
            System.out.println("objects are equal");


        System.out.println("-------------Test Threads exthread------------------------");
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new RunThread());
            thread.start();
        }

        System.out.println("-------------Test Threads Runnable------------------------");
        for (int i = 0; i < 5; i++) {
            ExThread exThread = new ExThread();
            exThread.start();
        }
        System.out.println("-------------Test thread safe singleton------------------------");
//done in seperate class
        System.out.println("-------------Test builder------------------------");
        User user = new User.UserBuilder(1, "zee").build();
        System.out.println(user.getId() + " " + user.getName());
        System.out.println("-------------Test factory------------------------");
        System.out.println("-------------Test twosum------------------------");//done
        System.out.println();
        System.out.println("-------------Test count words------------------------");
        System.out.println("-------------factorial using recursion------------------------");
        System.out.println(factorial(5));
        System.out.println("-------------rotate array------------------------");
        rotateArr(new int[]{1,2,3,4,5,6}, 2);
        System.out.println();
        System.out.println("-------------flatmap------------------------");
        System.out.println();
        System.out.println("-------------lambda exp------------------------");
    }

    private int id;
    private String name;

    private double income;

    public Person(int id, String name, double income) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return name.equals(p.name) && id == p.id && Double.compare(p.income, income) == 0;
    }

    @Override
    public int hashCode() {
        int res = 17;
        res = 31 * res + id;
        res = 31 * res + ((name != null) ? name.hashCode() : 0);
        return res;
    }

    @Override
    public int compareTo(@NonNull Person o) {
        if (id > o.getId()) return 1;
        if (id < o.getId()) return -1;
        else return name.compareTo(o.getName());
    }
}

class NameComp implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}


class IdComp implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
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

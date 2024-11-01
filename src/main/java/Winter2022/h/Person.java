package Winter2022.h;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements Comparable<Person> {

    private int id;
    private String name;
    private double salary;

    private String department;


    public Person(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        Person p1 = new Person(10, "zee", 1000);
        Person p2 = new Person(20, "sha", 2000);
        Person p3 = new Person(30, "akr", 3000);
        Person p4 = new Person(10, "akr", 3000);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        Map<Integer, Person> map = new HashMap<>();
        map.put(1, p1);
        map.put(2, p2);
        map.put(3, p3);
        map.put(4, p4);

        System.out.println("-------------testing distinct id/name using streams------------------------");
        List<Person> distinct = list.stream().distinct().collect(Collectors.toList());
        for (Person p : distinct) {
            System.out.println(p.getId() + " " + p.getName() + " " + p.getSalary());
        }
        System.out.println("-------------testing average income using streams------------------------");
        System.out.println("average income: " + list.stream().mapToDouble(x -> x.salary).average().orElse(0.0));
        System.out.println("-------------testing max salary using streams------------------------");
        System.out.println("max salary: " + list.stream().mapToDouble(x -> x.salary).max().orElseThrow(IllegalArgumentException::new));
        System.out.println("-------------testing sort student id reverse using streams------------------------");

        for (Person p : list.stream().sorted(Comparator.comparingInt(Person::getId).reversed().thenComparing(Person::getName)).collect(Collectors.toList())) {
            System.out.println(p.getId() + p.getName() + " " + p.getSalary());
        }
        System.out.println("-------------testing sort players by salary/goals------------------------");
        List<Map.Entry<Integer, Person>> sortBySalary = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
        for (Map.Entry<Integer, Person> p : sortBySalary) {
            System.out.println(p.getKey() + " " + p.getValue().getId());
        }
        System.out.println("-------------testing foreach method in hashmap- new java 8------------------------");
        map.forEach((key, value) -> System.out.println(key + " " + value.id + " " + value.name + " " + value.salary));
        System.out.println("-------------testing comparables------------------------");
        System.out.println("-------------testing comparators name------------------------");
        System.out.println("-------------testing comparators id------------------------");
        System.out.println("-------------testing equals and hashcode------------------------");
        System.out.println("-------------Test ExThread------------------------");
        System.out.println("-------------Test Threads Runnable------------------------");
        System.out.println("-------------Test thread safe singleton------------------------");
        //done in seperate class
        System.out.println("-------------Test builder------------------------");
        System.out.println("-------------Test factory------------------------");
        System.out.println("-------------Test twosum------------------------");
        System.out.println("-------------Test count words------------------------");
        System.out.println("-------------factorial using recursion------------------------");
        System.out.println("-------------rotate array------------------------");
        System.out.println("-------------flatmap------------------------");//done
        getFlatMap();
        System.out.println("-------------lambda exp------------------------");//done
        //done in seperate package
        System.out.println("-------------3rd highest salary------------------------");//done
        //done in seperate package
        System.out.println("-------------delete hashmap entries------------------------");


    }

    static void getFlatMap() {
        //flatmap for Strings to integers
        List<String> strings = Arrays.asList("1,2,3", "4,5,6", "7,8,9");

        List<Integer> list = strings.stream()
                .flatMap(x -> Arrays.stream(x.split(",")))
                .map(Integer::parseInt)
                .toList();

        for (int a : list) {
            System.out.print(a + " ");
        }
        System.out.println();

        //flatmap of Strings to characters
        List<String> stringList = Arrays.asList("hello", "world", "zeeshan");

        List<Character> characters = stringList.stream()
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .toList();

        for (char a : characters) {
            System.out.print(a + " ");
        }
        System.out.println();

        //flatmap of Integers to Integers
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));

        List<Integer> integerList = lists.stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());

        for (int a : integerList) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    @Override
    public int compareTo(@NonNull Person o) {
        if (id > o.id) return 1;
        if (id < o.id) return -1;
        else return name.compareTo(o.name);
    }
}

class IdComp implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getId() - o2.getId();
    }
}

class NameComp implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class SalaryComp implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Double.compare(o1.getSalary(), o2.getSalary());
    }
}

class ExThread extends Thread {
    @Override
    public void run() {
        System.out.println("exthread: " + Thread.currentThread().getId());
    }
}

class RunThread implements Runnable {

    @Override
    public void run() {
        System.out.println("runthread: " + Thread.currentThread().getId());
    }
}

class TSingleton {
    private static volatile TSingleton instance;

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



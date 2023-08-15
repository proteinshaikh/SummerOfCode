package Winter2022.a;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Person implements Comparable<Person> {
    private int id;
    private String name;
    private double income;

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() == o.getClass()) return false;
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return this.getName().equals(p.getName()) && this.getId() == p.getId() && this.getIncome() == p.getIncome();

    }

    @Override
    public int hashCode() {
        int res = 17;
        res = 31 * res + this.getId();
        res = 31 * res + this.getId();
        res = 31 * res + ((this.getName() != null) ? this.getName().hashCode() : 0);
        return res;
    }

    @Override
    public int compareTo(@NotNull Person o) {
        if (this.getId() > o.getId()) return 1;
        if (this.getId() < o.getId()) return -1;
        else return this.getName().compareTo(o.getName());
    }

    public static void main(String[] args) throws Exception {

        nullParameterToMethod(null); //pass null here and check

        Map<Integer, Person> map = new HashMap<>();
        Person p1 = new Person(1, "Zee", 1000);
        Person p2 = new Person(2, "akr", 2000);
        Person p3 = new Person(3, "shai", 3000);
        Person p4 = new Person(3, "test", 1000);

        map.put(1, p1);
        map.put(2, p2);
        map.put(3, p3);
        map.put(4, p4);

        System.out.println("-------------testing average income using streams------------------------");
        System.out.println("-------------testing average income using streams------------------------");
        System.out.println("-------------testing max salary using streams------------------------");
        System.out.println("-------------testing sort student id reverse using streams------------------------");
        System.out.println("-------------testing comparables------------------------");
        System.out.println("-------------testing comparators name------------------------");
        System.out.println("-------------Test Threads------------------------");

        double avgincome = map.entrySet().stream().mapToDouble(x -> x.getValue().getIncome()).average().orElse(0.0);
        System.out.println("averageincome is : " + avgincome);

        System.out.println("-------------testing max salary using streams------------------------");
        double maxIncome = map.entrySet().stream().mapToDouble(x -> x.getValue().getIncome()).max().orElseThrow(Exception::new);
        System.out.println("max income is : " + maxIncome);

        System.out.println("-------------testing sort student id reverse using streams------------------------");

        List<Map.Entry<Integer, Person>> list = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
        for (Map.Entry<Integer, Person> m : list) {
            System.out.println(m.getKey() + " : " + m.getValue().getId());
        }

        System.out.println("-------------testing comparables------------------------");

        List<Person> plist = new ArrayList<>();
        plist.add(p1);
        plist.add(p2);
        plist.add(p3);
        plist.add(p4);

        Collections.sort(plist);
        for (Person p : plist) {
            System.out.println(p.getId() + " : " + p.getName() + " : " + p.getId());
        }

        System.out.println("-------------testing comparators name------------------------");
        Collections.sort(plist, new NameComparator());
        for (Person p : plist) {
            System.out.println(p.getId() + " : " + p.getName() + " : " + p.getId());

        }
        System.out.println("-------------testing comparators id------------------------");
        Collections.sort(plist, new IdComparator());
        for (Person p : plist) {
            System.out.println(p.getId() + " : " + p.getName() + " : " + p.getId());
        }

    }

    static void nullParameterToMethod(Object o) {
        System.out.println("object : " + o);
    }

    static void nullParameterToMethod(String s) {
        System.out.println("String : " + s);
        String str = null;
        System.out.println(str);
    }

    static void nullParameterToMethod(int i) {
        System.out.println("int : " + i);
    }
}


class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o2.getId() - o1.getId();
    }
}


class IdComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

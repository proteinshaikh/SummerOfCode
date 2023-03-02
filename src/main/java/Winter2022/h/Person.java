package Winter2022.h;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private int id;
    private String name;
    private double salary;

    public Person(int id, String name, double salary) {
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
        if (getClass() != o.getClass()) return false;
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return name.equals(p.name) && (id == p.id) && (Double.compare(salary, p.salary) == 0);
    }

    @Override
    public int hashCode() {
        int res = 17;
        res = 31 * res + id;
        res = 31 * res + ((name != null) ? name.hashCode() : 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("-------------testing distinct id/name using streams------------------------");
        System.out.println("-------------testing average income using streams------------------------");
        System.out.println("-------------testing max salary using streams------------------------");
        System.out.println("-------------testing sort student id reverse using streams------------------------");
        System.out.println("-------------testing comparables------------------------");
        System.out.println("-------------testing comparators name------------------------");
        System.out.println("-------------testing comparators id------------------------");
        System.out.println("-------------testing equals and hashcode------------------------");
        System.out.println("-------------Test ExThread------------------------");
        System.out.println("-------------Test Threads Runnable------------------------");
        System.out.println("-------------Test thread safe singleton------------------------");
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
    }

    static void getFlatMap() {
        //flatmap for Strings to integers
        List<String> strings = Arrays.asList("1,2,3", "4,5,6", "7,8,9");

        List<Integer> list = strings.stream()
                .flatMap(x -> Arrays.stream(x.split(",")))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int a : list) {
            System.out.print(a + " ");
        }
        System.out.println();

        //flatmap of Strings to characters
        List<String> stringList = Arrays.asList("hello", "world", "zeeshan");

        List<Character> characters = stringList.stream()
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());

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
}

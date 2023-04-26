package Winter2022.h.hashcodeCollision;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


    public static void main(String[] args) {
        OpenAddressingHashMap<Person, Integer> map = new OpenAddressingHashMap<>();

        Person alice = new Person("Alice", 25);
        Person bob = new Person("Bob", 30);

        map.put(alice, 1);
        map.put(bob, 2);

        System.out.println("Alice: " + map.get(alice)); // Output: Alice: 1
        System.out.println("Bob: " + map.get(bob));     // Output: Bob: 2
        System.out.println("Charlie: " + map.get(new Person("Charlie", 35))); // Output: Charlie: null
    }
}

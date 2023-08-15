package CoreJava.OOPS;


import java.util.ArrayList;
import java.util.List;

public class OOPSTest {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Zeeshan", "Mumbai", 400026, 12345));
        persons.add(new Nominee("Shaikh", "Mumbai", 400042, 234342, "father"));
        persons.add(new Dependent("Shaikh", "Mumbai", 400042, 234342, "father", 2));
        System.out.println(persons.toString());

        List<Person> nomineeList = new ArrayList<>();
        Nominee nominee = new Nominee();
        System.out.println(nominee.getClass().getTypeName());

        //upcasting
        Person person = new Nominee();
        System.out.println(person.getClass().getTypeName());

        //downcasting
        Nominee nominee1 = (Nominee) person;
        System.out.println(nominee1.getClass().getTypeName());


    }
}

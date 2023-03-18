package Winter2022.h.clone;


public class Person implements Cloneable {

    private String name;
    private int age;
    private Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException { //deep clone
        Person person = (Person) super.clone();
        person.address = (Address) address.clone();
        return person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public static void main(String[] args) {

        Address a1 = new Address("6th", "mumbai", "maha");
        Person p1 = new Person("zee", 1, a1);

        System.out.println("original person" + p1);

        try {
            Person zeeClone = (Person) p1.clone();
            System.out.println("cloned person: " + zeeClone);
            System.out.println("are address same object: " + (p1.getAddress() == zeeClone.getAddress()));
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

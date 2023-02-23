package Winter2022.EqualsandHashcode;

import boot.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Employee {

    private String name;
    private int id;

    public Employee(String name, int id){
        this.name=name;
        this.id=id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || getClass() != o.getClass()) return false;
        Employee e = (Employee) o;
        return name.equals(e.name) && id == e.id;
    }

    /*
    * You should override the hashCode method if you want to use instances of the class as keys in hash-based collections
    * */
    @Override
    public int hashCode(){
        return Objects.hash(name, id);

    }

    public static void main(String[] args) {
        Map<Employee, Integer> map = new HashMap<>();
        map.put(new Employee("zee",4), 1);
        map.put(new Employee("test", 5), 2);
        map.put(new Employee("akr",6), 3);

        Employee key= new Employee("test", 5);
        System.out.println(map.get(key));
    }
}

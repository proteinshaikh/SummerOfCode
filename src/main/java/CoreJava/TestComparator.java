package CoreJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparator<Employee> {
    String name;
    int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        return 0;
    }
}

class NameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.name.compareTo(o2.name);
    }
}

class IdComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.id == o2.id)
            return 0;
        else if (o1.id > o2.id)
            return 1;
        else
            return -1;
    }
}


public class TestComparator {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Zeeshan", 1));
        list.add(new Employee("Shaikh",2));

        Collections.sort(list, new NameComparator());
        for(Employee emp: list){
            System.out.println("Name Comparator :" +emp.name + "  " + emp.id);
        }


        Collections.sort(list, new IdComparator());
        for(Employee emp: list){
            System.out.println("ID Comparator :" +emp.name + "  " + emp.id);
        }
    }

}

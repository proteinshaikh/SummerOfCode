package Winter2022;

import Winter2022.EqualsandHashcode.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        Map<Integer, Employee> map = new HashMap<>();
        map.put(1, new Employee("zee",10));
        map.put(2, new Employee("akr",20));
        map.put(3, new Employee("tst",30));
        map.put(4, new Employee("sha",40));

       map.entrySet().stream().forEach(e -> System.out.println(e.getKey()+" : "+e.getValue().getId()));
       map.entrySet().stream().forEach(e -> System.out.println(e.getKey()+" : "+e.getValue().getName().toUpperCase(Locale.ROOT)));

       List<Employee> list = new ArrayList<>();
        list.add(new Employee("zee",10));
        list.add(new Employee("akr",20));
        list.add( new Employee("tst",30));
        list.add( new Employee("sha",40));

        List<Employee> sortbyId = list.stream().sorted(Comparator.comparingInt(Employee::getId).reversed()).collect(Collectors.toList());

        for(Employee e: sortbyId){
            System.out.println(e.getId()+" : "+e.getName());
        }
    }
}

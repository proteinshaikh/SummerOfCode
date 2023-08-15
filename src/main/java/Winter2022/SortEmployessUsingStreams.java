package Winter2022;

import Winter2022.EqualsandHashcode.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortEmployessUsingStreams {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("zee", 10));
        list.add(new Employee("akr", 20));
        list.add(new Employee("tst", 30));
        list.add(new Employee("sha", 40));

        Map<Integer, Employee> map = new HashMap<>();
        map.put(1, list.get(0));
        map.put(2, list.get(1));
        map.put(3, list.get(2));
        map.put(4, list.get(3));
        for (Employee employee : getsortedBasedOnId(list)) {
            System.out.println(employee.getId() + " : " + employee.getName());
        }
        sortObject(map);


    }

    static List<Employee> getsortedBasedOnId(List<Employee> list) {

        return list.stream().sorted(Comparator.comparingInt(Employee::getId).reversed()).collect(Collectors.toList());

    }

    static void sortObject(Map<Integer, Employee> employeeMap) {
        employeeMap.entrySet().stream().forEach(x -> System.out.println(x.getKey() + " : " + x.getValue().getId()));
    }
}

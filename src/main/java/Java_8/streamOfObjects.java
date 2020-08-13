package Java_8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamOfObjects {

    public static void main(String[] args) {

        List<EmployeePojo> employee = Arrays.asList(
        new EmployeePojo(1,"zeeshan", 25, 10000),
        new EmployeePojo(2,"akram", 55, 20000),
        new EmployeePojo(3,"shaikh", 67, 30000),
        new EmployeePojo(4,"zeeshan", 19, 5000),
        new EmployeePojo(6,"ali", 62, 100000),
        new EmployeePojo(5,"test", 14, 2000));

        //scenario 1: list of employees with name zeeshan
        System.out.println("List of employees with name zeeshan : " +(employee.stream().filter(e -> e.getName().equalsIgnoreCase("zeeshan")).collect(Collectors.toList())));

        //get id of employee with salary 5000

        //System.out.println(employee.stream().filter(e -> e.getSalary() == 5000).collect(Collectors.)));
        System.out.println(employee.stream().filter(e -> e.getSalary() == 5000).collect(Collectors.toList()));
        //System.out.println(emp);

        for(EmployeePojo i: employee){
            if(i.getSalary()==5000){
                System.out.println(i.getId());
            }
        }
    }
}

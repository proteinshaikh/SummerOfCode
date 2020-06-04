package Java_8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Stream_Of_Objects {

    public static class Employee{
        public String salary;
        public Employee(String salary){
            this.salary=salary;
        }
    }

    public static void main(String[] args) {
        List<Employee> list=new ArrayList<Employee>();
        list.add(new Employee("1000"));
        list.add(new Employee("2000"));
        list.add(new Employee("3000"));

        int sum=
                list.stream()
                .map(employee -> employee.salary)
                .map(Integer::parseInt)
                .reduce(0, (tempSum,value) -> tempSum+value);
        System.out.println("salary sum= " +sum);

    }
}

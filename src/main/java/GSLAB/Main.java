package GSLAB;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(10, "Zeeshan", "IT"));
        employeeList.add(new Employee(20, "Akram", "Marketing"));
        employeeList.add(new Employee(30, "Shaikh", "Finance"));
        employeeList.add(new Employee(40, "Test", "HR"));

        List<Department> departments = new ArrayList<>();
        departments.add(new Department(1, "IT"));
        departments.add(new Department(2, "Marketing"));
        departments.add(new Department(3, "Finance"));
        departments.add(new Department(4, "HR"));

        


    }
}

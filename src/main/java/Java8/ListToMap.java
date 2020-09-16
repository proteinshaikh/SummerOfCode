package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

public class ListToMap {
    public static void main(String[] args) {
        List<Employees> emp = Arrays.asList(
                new Employees(1, "Zeeshan", 10000, Gender.MALE),
                new Employees(2, "Sana", 25000, Gender.FEMALE),
                new Employees(3, "Ali", 1000, Gender.MALE),
                new Employees(4, "Jony", 4630, Gender.OTHER),
                new Employees(5, "Akbar", 500000000, Gender.MALE),
                new Employees(6, "Shaba", 10000, Gender.FEMALE),
                new Employees(7, "Guli", 730, Gender.MALE)

        );
        Map<Gender, List<Employees>> empgrp = emp.stream().collect(Collectors.groupingBy(Employees::getGender));
        System.out.println(empgrp);


    }

}


class Employees {
    private int id;
    private String name;
    private long salary;
    private Gender gender;

    Employees(int id, String name, long salary, Gender gender) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", gender=" + gender +
                '}';
    }
}

enum Gender {
    MALE, FEMALE, OTHER;
}
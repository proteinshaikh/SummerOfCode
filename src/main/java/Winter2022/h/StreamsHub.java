package Winter2022.h;

import java.util.List;
import java.util.stream.Stream;

public class StreamsHub {


    //total salary of all employees whose age is greater than 30
    static double getTotalSalaryByAge(List<Person> persons, int age) {
        return persons.stream().filter(e -> e.getId() > 30)
                .mapToDouble(Person::getSalary)
                .sum();
    }


    //maximum salary of all employees in a department
    static double getMaxSalaryByDept(List<Person> persons, String dept) {
        return persons.stream().filter(e -> e.getDepartment().equals(dept))
                .mapToDouble(Person::getSalary)
                .max()
                .orElse(Double.NaN);
    }

    //find the first five even numbers greater than 10
    static void getFirstNNums() {
        Stream.iterate(12, n -> n + 2)
                .filter(n -> n > 10)
                .limit(5)
                .forEach(System.out::println);
    }
}

package Summer2023.c;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private final int id;
    private final String name;
    private final int age;
    private final int experience;
    private final double Salary;
    private final String department;
}

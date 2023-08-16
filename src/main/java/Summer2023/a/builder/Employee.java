package Summer2023.a.builder;

import java.math.BigDecimal;

public class Employee {
    private final int id;
    private final String name;
    private final BigDecimal salary;

    public Employee(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.salary = builder.salary;
    }

    private static class Builder {
        private int id;
        private String name;
        private BigDecimal salary;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;

        }

        public Builder setSalary(BigDecimal salary) {
            this.salary = salary;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        Employee employee = new Employee.Builder()
                .setId(1)
                .setName("John Doe")
                .setSalary(new BigDecimal("1000.50"))
                .build();
        System.out.println(employee);

    }
}

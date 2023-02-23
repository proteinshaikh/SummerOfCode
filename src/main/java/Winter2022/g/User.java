package Winter2022.g;

public class User {

    private final int id;
    private final String name;

    private final double salary;//optional

    public User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.salary = builder.salary;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    static class Builder {
        private int id;
        private String name;

        private double salary;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;

        }

        public Builder salary(double salary) {
            this.salary = salary;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

}

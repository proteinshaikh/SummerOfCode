package winter2024.builder;

public class Person {

    private final String name;

    private Person(PersonBuilder builder) {
        this.name = builder.name;
    }

    public String getName() {
        return name;
    }


    public static class PersonBuilder {
        private final String name;

        public PersonBuilder(String name) {
            this.name = name;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person person = new PersonBuilder("John")
                .build();

        System.out.println(person);
    }
}


package Winter2022.builderpattern;

import javax.jws.soap.SOAPBinding;

class User {

    private final String firstName;
    private final String lastName;
    private final String phone;
    private final int age;

    public User(UserBuilder userBuilder) {
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.phone = userBuilder.phone;
        this.age = userBuilder.age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

//inner class
    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private String phone;
        private int age;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;

        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public User build() {
            return new User((this));
        }
    }
}

public class TestBuilderPattern {
    public static void main(String[] args) {
        User user = new User.UserBuilder("zee", "sha")
                .age(28)
                .phone("1234")
                .build();
        System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getAge() + " " + user.getPhone());
    }
}

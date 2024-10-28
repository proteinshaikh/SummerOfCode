package winter2024.customannotation;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("John", "john.doe@example.com");
            AnnotationValidator.validate(user);
            System.out.println("User is valid!");

            // Example of invalid user
            User invalidUser = new User("Jo", "short@example.com");
            AnnotationValidator.validate(invalidUser);
        } catch (Exception e) {
            System.out.println("User is invalid!");
        }
    }
}


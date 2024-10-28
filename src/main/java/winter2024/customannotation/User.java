package winter2024.customannotation;

public class User {
    @ValidateLength(min = 3, max = 15)
    private String username;

    @ValidateLength(min = 5, max = 50)
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}


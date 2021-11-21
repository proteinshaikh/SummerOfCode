package OOP2;

public class PrimeMinister extends President{



    public PrimeMinister(String role) {
        Role = role;
    }

    public PrimeMinister(String name, int netWorth, String role) {
        super(name, netWorth);
        Role = role;
    }

    private String Role;

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}

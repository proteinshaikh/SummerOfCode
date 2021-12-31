package Java8.mapflatmap;

import java.util.List;

public class Customer {

    private String name;
    private List<Integer> phone;

    public Customer() {
    }

    public Customer(String name, List<Integer> phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPhone() {
        return phone;
    }

    public void setPhone(List<Integer> phone) {
        this.phone = phone;
    }
}

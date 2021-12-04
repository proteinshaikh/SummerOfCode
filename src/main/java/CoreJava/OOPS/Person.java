package CoreJava.OOPS;

import java.util.Objects;

public class Person {

    private String name;
    private String city;
    private int pincode;
    private int accountNo;

    public Person(){

    }

    public Person(String name, String city, int pincode, int accountNo) {
        this.name = name;
        this.city = city;
        this.pincode = pincode;
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return pincode == person.pincode && accountNo == person.accountNo && name.equals(person.name) && city.equals(person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, pincode, accountNo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", pincode=").append(pincode);
        sb.append(", accountNo=").append(accountNo);
        sb.append('}');
        return sb.toString();
    }
}

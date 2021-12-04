package CoreJava.OOPS;

import java.util.Objects;

public class Dependent extends Nominee {

    private int numberOfDependent;

    public Dependent() {
    }

    public Dependent(String name, String city, int pincode, int accountNo, String relation, int numberOfDependent) {
        super(name, city, pincode, accountNo, relation);
        this.numberOfDependent = numberOfDependent;
    }

    public int getNumberOfDependent() {
        return numberOfDependent;
    }

    public void setNumberOfDependent(int numberOfDependent) {
        this.numberOfDependent = numberOfDependent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dependent dependent = (Dependent) o;
        return numberOfDependent == dependent.numberOfDependent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfDependent);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dependent{");
        sb.append("name='").append(super.getName()).append('\'');
        sb.append(", city='").append(super.getCity()).append('\'');
        sb.append(", pincode=").append(super.getPincode()).append('\'');
        sb.append(", accountNo=").append(super.getAccountNo()).append('\'');
        sb.append(", relation='").append(super.getRelation()).append('\'');
        sb.append(", numberOfDependent='").append(numberOfDependent).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

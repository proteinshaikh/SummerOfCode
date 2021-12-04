package CoreJava.OOPS;

import java.util.Objects;

public class Nominee extends Person {

    private String relation;


    public Nominee() {

    }

    public Nominee(String name, String city, int pincode, int accountNo, String relation) {
        super(name, city, pincode, accountNo);
        this.relation = relation;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Nominee nominee = (Nominee) o;
        return relation.equals(nominee.relation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), relation);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Nominee{");
        sb.append("name='").append(super.getName()).append('\'');
        sb.append(", city='").append(super.getCity()).append('\'');
        sb.append(", pincode=").append(super.getPincode()).append('\'');
        sb.append(", accountNo=").append(super.getAccountNo()).append('\'');
        sb.append(", relation='").append(relation).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

package CoreJava.Immutable;

public class TestImmutableEmployee {
    public static void main(String[] args) {

        Age age = new Age();
        age.setDay(1);
        age.setMonth(12);
        age.setYear(1995);
        ImmutableEmployee immutableEmployee = new ImmutableEmployee("Zeeshan", 1, age);

        System.out.println(" Zeeshan's age before modification: " + immutableEmployee.getAge().getYear());
        immutableEmployee.getAge().setYear(1996);
        System.out.println(" Zeeshan's age before modification: " + immutableEmployee.getAge().getYear());

    }
}

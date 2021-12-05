package CoreJava.Immutable;

public final class ImmutableEmployee {

    private final String employeeName;
    private final int employeeId;
    private final Age age;

    public ImmutableEmployee(String employeeName, int employeeId, Age age) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.age = age;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Age getAge() {

        Age cloneAge = new Age();
        cloneAge.setDay(this.age.getDay());
        cloneAge.setMonth(this.age.getMonth());
        cloneAge.setYear(this.age.getYear());
        return cloneAge;
    }
}

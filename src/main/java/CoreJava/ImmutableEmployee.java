package CoreJava;

public final class ImmutableEmployee {

    private final String employeeName;
    private final int employeeId;

    public ImmutableEmployee(String employeeName, int employeeId) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }
}

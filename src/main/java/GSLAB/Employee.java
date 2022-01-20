package GSLAB;

public class Employee {

    private int employeeId;
    private String employeeName;
    private String deptName;

    public Employee(int employeeId, String employeeName, String deptName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.deptName = deptName;
    }


    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}

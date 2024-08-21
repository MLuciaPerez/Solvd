package Model;

public abstract class Employee extends Person {
    protected String employeeId;

    // Constructor
    public Employee(String name, int age, String employeeId) {
        super(name, age);
        this.employeeId = employeeId;
    }

    // Getter and Setter for employeeId
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return super.toString() + ", Employee ID: " + employeeId;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + employeeId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Employee employee = (Employee) obj;
        return employeeId.equals(employee.employeeId);
    }
}
package Model;

public abstract class MedicalStaff extends Person {
    protected String employeeId;  // Protected modifier

    // Constructor
    public MedicalStaff(String name, int age, String employeeId) {
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

    // Abstract method to be implemented by subclasses
    public abstract void performDuties();

    // Override toString() method from Person
    @Override
    public String toString() {
        return super.toString() + ", Employee ID: " + employeeId;
    }

    // Override hashCode() method from Person
    @Override
    public int hashCode() {
        return super.hashCode() + employeeId.hashCode();
    }

    // Override equals() method from Person
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        MedicalStaff staff = (MedicalStaff) obj;
        return employeeId.equals(staff.employeeId);
    }
}
package Model;

public class Receptionist extends Employee {
    private String deskNumber;

    // Constructor
    public Receptionist(String name, int age, String employeeId, String deskNumber) {
        super(name, age, employeeId);
        this.deskNumber = deskNumber;
    }

    // Getter and Setter
    public String getDeskNumber() {
        return deskNumber;
    }

    public void setDeskNumber(String deskNumber) {
        this.deskNumber = deskNumber;
    }

    // Implement the abstract method from Person
    @Override
    public void performDuties() {
        System.out.println("Receptionist " + getName() + " is managing the desk at number " + deskNumber + ".");
    }

    @Override
    public String toString() {
        return super.toString() + ", Desk Number: " + deskNumber;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + deskNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Receptionist receptionist = (Receptionist) obj;
        return deskNumber.equals(receptionist.deskNumber);
    }
}
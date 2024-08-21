package Model;

import Model.Interfaces.Treatable;

public class Nurse extends MedicalStaff implements Treatable {
    private String shift;

    // Constructor
    public Nurse(String name, int age, String employeeId, String shift) {
        super(name, age, employeeId);
        this.shift = shift;
    }

    // Implement Treatable interface method
    @Override
    public void treatPatient(Patient patient) {
        System.out.println("Nurse " + getName() + " is assisting in treating patient: " + patient.getName());
    }

    // Implement performDuties method from MedicalStaff
    @Override
    public void performDuties() {
        System.out.println("Performing nursing duties during " + shift + " shift.");
    }

    // Static block
    static {
        System.out.println("Static block in Nurse class executed.");
    }

    // Getter and Setter for shift
    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
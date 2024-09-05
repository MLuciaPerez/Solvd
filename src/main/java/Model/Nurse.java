package Model;

import Model.Interfaces.Treatable;

import java.util.HashSet;

public class Nurse extends MedicalStaff implements Treatable {
    private String shift;
    private HashSet<String> medicalEquipment; //Keep track of unique medical equipment a nurse handles.

    // Constructor
    public Nurse(String name, int age, String employeeId, String shift) {
        super(name, age, employeeId);
        this.shift = shift;
        this.medicalEquipment = new HashSet<>();
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

    public void addEquipment(String equipment) {
        medicalEquipment.add(equipment);
        System.out.println("Equipment added: " + equipment);
    }

    public HashSet<String> getMedicalEquipment() {
        return medicalEquipment;
    }
}
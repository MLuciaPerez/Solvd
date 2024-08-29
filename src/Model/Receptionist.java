package Model;

import java.util.LinkedList;

public class Receptionist extends Employee {
    private String deskNumber;
    private LinkedList<Patient> patientQueue;

    // Constructor
    public Receptionist(String name, int age, String employeeId, String deskNumber) {
        super(name, age, employeeId);
        this.deskNumber = deskNumber;
        this.patientQueue = new LinkedList<>();
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

    // Method to add a patient to the queue
    public void checkInPatient(Patient patient) {
        patientQueue.add(patient);
        System.out.println("Patient checked in: " + patient.getName());
    }

    // Method to get the next patient from the queue
    public Patient nextPatient() {
        Patient patient = patientQueue.poll();
        if (patient != null) {
            System.out.println("Next patient: " + patient.getName());
        } else {
            System.out.println("No patients in the queue.");
        }
        return patient;
    }

    // Method to show all patients in the queue
    public void showPatientQueue() {
        System.out.println("Patient queue:");
        for (Patient patient : patientQueue) {
            System.out.println(patient.getName());
        }
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
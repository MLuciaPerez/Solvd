package Model;

import Model.Interfaces.Payable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class Patient extends Person implements Payable {
    protected String patientId;
    protected String ailment;
    private Billing billing;
    private ArrayList<Medication> medications;

    // Constructor
    public Patient(String name, int age, String patientId, String ailment, Billing billing, ArrayList<Medication> medications) {
        super(name, age);
        this.patientId = patientId;
        this.ailment = ailment;
        this.billing = billing;
        this.medications = medications;
    }

    // Implement Payable interface method

    public void processPayment() {
        System.out.println("Processing payment for patient: " + getName());
    }

    // Implement performDuties from Person
    public void performDuties() {
        System.out.println("PatientZ does not have specific duties.");
    }

    // Getters and Setters
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getAilment() {
        return ailment;
    }

    public void setAilment(String ailment) {
        this.ailment = ailment;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(ArrayList<Medication> medications) {
        this.medications = medications;
    }

    // Final method
    public final void printPatientInfo() {
        System.out.println("Patient ID: " + patientId + ", Ailment: " + ailment);
    }

    // Override toString() method
    @Override
    public String toString() {
        return super.toString() + ", Patient ID: " + patientId + ", Ailment: " + ailment;
    }

    // Override hashCode() method
    @Override
    public int hashCode() {
        return super.hashCode() + patientId.hashCode() + ailment.hashCode();
    }

    // Override equals() method
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Patient patient = (Patient) obj;
        return patientId.equals(patient.patientId) && ailment.equals(patient.ailment);
    }
}
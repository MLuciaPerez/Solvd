package Model.Classes;

import Model.Enums.AppointmentStatus;
import Model.Interfaces.Payable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

public final class Patient extends Person implements Payable {
    private static final Logger logger = LogManager.getLogger(Patient.class);
    protected String patientId;
    protected String ailment;
    private Billing billing;
    private ArrayList<Medication> medications; //Array of medications
    private TreeSet<Date> appointmentDates;
    private AppointmentStatus appointmentStatus; // Enum as an attribute

    // Constructor
    public Patient(String name, int age, String patientId, String ailment, Billing billing, ArrayList<Medication> medications,AppointmentStatus appointmentStatus) {
        super(name, age);
        this.patientId = patientId;
        this.ailment = ailment;
        this.billing = billing;
        this.medications = medications;
        this.appointmentDates = new TreeSet<>();
        this.appointmentStatus = appointmentStatus;
        logger.info("Patient created: " + name + ", Appointment Status: " + appointmentStatus);
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

    @Override
    public String getName() {
        return super.getName();
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

    public void addAppointmentDate(Date date) {
        appointmentDates.add(date);
        System.out.println("Appointment date added: " + date);
    }

    public TreeSet<Date> getAppointmentDates() {
        return appointmentDates;
    }
}
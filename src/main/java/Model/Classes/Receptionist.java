package Model.Classes;

import Model.Enums.PriorityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

public class Receptionist extends Employee {
    private static final Logger logger = LogManager.getLogger(Receptionist.class);
    private String deskNumber;
    private LinkedList<Patient> patientQueue;
    private PriorityLevel priorityLevel; // Enum as an attribute


    // Constructor
    public Receptionist(String name, int age, String employeeId, String deskNumber, PriorityLevel priorityLevel) {
        super(name, age, employeeId);
        this.deskNumber = deskNumber;
        this.patientQueue = new LinkedList<>();
        this.priorityLevel = priorityLevel;
        logger.info("Receptionist created: " + name + ", Priority Level: " + priorityLevel);
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
        logger.info("Receptionist " + getName() + " is managing the desk at number " + deskNumber + ".");
    }

    // Method to add a patient to the queue
    public void checkInPatient(Patient patient) {
        patientQueue.add(patient);
        logger.info("Patient checked in: " + patient.getName());
    }

    // Method to get the next patient from the queue
    public Patient nextPatient() {
        Patient patient = patientQueue.poll();
        if (patient != null) {
            logger.info("Next patient: " + patient.getName());
        } else {
            logger.info("No patients in the queue.");
        }
        return patient;
    }

    // Method to show all patients in the queue
    public void showPatientQueue() {
        logger.info("Patient queue:");
        for (Patient patient : patientQueue) {
            logger.info(patient.getName());
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
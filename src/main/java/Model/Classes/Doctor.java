package Model.Classes;

import Model.Enums.Specialty;
import Model.Interfaces.Diagnosable;
import Model.Interfaces.MedicationProvider;
import Model.Interfaces.Treatable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Doctor extends MedicalStaff implements Diagnosable, MedicationProvider, Treatable{

    private static final Logger logger = LogManager.getLogger(Doctor.class);
    private Specialty specialty; // Enum as an attribute

    // Static variable
    public static final String role = "Doctor";
    private List<Patient> patients;


    // Constructor
    public Doctor(String name, int age, String employeeId, Specialty specialty,List<Patient> patients) {
        super(name, age, employeeId);
        this.specialty = specialty;
        logger.info("Doctor created: " + name + ", Specialty: " + specialty);
        this.patients = patients;

    }

    // Implement Diagnosable interface method
    @Override
    public void diagnose(Patient patient) {
        logger.info("Doctor " + getName() + " is diagnosing patient: " + patient.getName() + " for " + patient.getAilment() + ".");
    }

    // Implement MedicationProvider interface method
    @Override
    public void prescribeMedication(Patient patient, String medication, String dosage) {
        logger.info("Doctor " + getName() + " prescribes " + medication + " with dosage " + dosage + " to patient: " + patient.getName() + ".");
        patient.getMedications().add(new Medication(medication, dosage));
    }

    //overloading of prescribeMedication
    public void prescribeMedication() {
        logger.info("Doctor " + getName() + " prescribes general medication.");
    }

    // Overloaded methods
    public void prescribeMedication(String medication) {
        logger.info("Doctor " + getName() + " prescribes " + medication + ".");
    }

    // Implement Treatable interface method
    @Override
    public void treatPatient(Patient patient) {
        logger.info("Doctor " + getName() + " is treating patient: " + patient.getName() + " for " + patient.getAilment() + ".");
    }


    // Getter for patients
    public List<Patient> getPatients() {
        return patients;
    }

    // Getter and Setter for specialty
    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        logger.info("Doctor " + getName() + " is performing duties in " + specialty + ".");
    }

    @Override
    public String toString() {

        return super.toString() + ", Specialty: " + specialty;
    }

    @Override
    public String getName() {

        return super.getName();
    }

    @Override
    public int hashCode() {

        return super.hashCode() + specialty.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Doctor doctor = (Doctor) obj;
        return specialty.equals(doctor.specialty);
    }
}
package Model.Classes;

import Model.Enums.Specialty;
import Model.Interfaces.Diagnosable;
import Model.Interfaces.MedicationProvider;
import Model.Interfaces.Treatable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Doctor extends MedicalStaff implements Diagnosable, MedicationProvider, Treatable{

    private static final Logger logger = LogManager.getLogger(Doctor.class);
    private Specialty specialty; // Enum as an attribute

    // Static variable
    public static final String role = "Doctor";


    // Constructor
    public Doctor(String name, int age, String employeeId, Specialty specialty) {
        super(name, age, employeeId);
        this.specialty = specialty;
        logger.info("Doctor created: " + name + ", Specialty: " + specialty);
    }

    // Implement Diagnosable interface method
    @Override
    public void diagnose(Patient patient) {
        System.out.println("Doctor " + getName() + " is diagnosing patient: " + patient.getName() + " for " + patient.getAilment() + ".");
    }

    // Implement MedicationProvider interface method
    @Override
    public void prescribeMedication(Patient patient, String medication, String dosage) {
        System.out.println("Doctor " + getName() + " prescribes " + medication + " with dosage " + dosage + " to patient: " + patient.getName() + ".");
        // Optionally, add the medication to the patient's list of medications
        patient.getMedications().add(new Medication(medication, dosage));
    }

    //overloading of prescribeMedication
    public void prescribeMedication() {

        System.out.println("Doctor " + getName() + " prescribes general medication.");
    }

    // Overloaded methods
    public void prescribeMedication(String medication) {
        System.out.println("Doctor " + getName() + " prescribes " + medication + ".");
    }

    // Implement Treatable interface method
    @Override
    public void treatPatient(Patient patient) {
        System.out.println("Doctor " + getName() + " is treating patient: " + patient.getName() + " for " + patient.getAilment() + ".");
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
        System.out.println("Doctor " + getName() + " is performing duties in " + specialty + ".");
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
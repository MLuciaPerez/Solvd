package Model;

import Model.Interfaces.Diagnosable;
import Model.Interfaces.MedicationProvider;
import Model.Interfaces.Treatable;

public class Doctor extends MedicalStaff implements Diagnosable, MedicationProvider, Treatable {
    private String specialty;

    // Static variable
    public static final String role = "Doctor";


    // Constructor
    public Doctor(String name, int age, String employeeId, String specialty) {
        super(name, age, employeeId);
        this.specialty = specialty;
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
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
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
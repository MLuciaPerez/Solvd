import Model.*;
import Model.Interfaces.Diagnosable;
import Model.Interfaces.MedicationProvider;
import Model.Interfaces.Treatable;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Creating Doctor and Nurse objects...");
        MedicalStaff doctor = new Doctor("Dr. Smith", 45, "D001", "Cardiology");
        MedicalStaff nurse = new Nurse("Nina Williams", 29, "N001", "Night");
        System.out.println("Doctor and Nurse objects created.\n");

        // Create Billing and Medication objects
        System.out.println("Creating Billing and Medication objects...");
        Billing billing = new Billing(null, 1500.00);
        ArrayList<Medication> medications = new ArrayList<>();
        medications.add(new Medication("Amoxicillin", "500mg"));
        medications.add(new Medication("Ibuprofen", "200mg"));
        System.out.println("Billing and Medication objects created.\n");

        // Instantiate a PatientZ object with Billing and Medications
        System.out.println("Instantiating PatientZ object...");
        Patient patient = new Patient("John Doe", 30, "P001", "Flu", billing, medications);
        System.out.println("PatientZ object instantiated.\n");

        // Link the Billing object back to the patient
        System.out.println("Linking Billing object back to the PatientZ...");
        billing.setPatient(patient);
        System.out.println("Billing object linked to PatientZ.\n");

        // Demonstrate treating the patient
        System.out.println("Demonstrating treating the patient using polymorphism...");
        ((Treatable) doctor).treatPatient(patient);
        ((Treatable) nurse).treatPatient(patient);
        System.out.println("Treatment demonstrated.\n");

        // Demonstrate prescribing medication
        System.out.println("Demonstrating prescribing medication...");
        ((MedicationProvider) doctor).prescribeMedication(patient, "Paracetamol", "500mg");
        System.out.println("Medication prescribed.\n");

        // Demonstrate diagnosis
        System.out.println("Demonstrating diagnosis...");
        ((Diagnosable) doctor).diagnose(patient);
        System.out.println("Diagnosis demonstrated.\n");

        // Demonstrate payment processing
        System.out.println("Demonstrating payment processing...");
        patient.processPayment();
        System.out.println("Payment processed.\n");

        // Demonstrate administrative management
        System.out.println("Demonstrating administrative management...");
        Administrator admin = new Administrator("Alice Johnson", 50, "Finance");
        admin.manage();
        System.out.println("Management demonstrated.\n");

        // Demonstrate static method calls
        System.out.println("Demonstrating static method calls...");

        // Crear una instancia de HospitalUtils
        HospitalUtils hospitalUtils = new HospitalUtils();

        // Registrar pacientes usando el método estático de HospitalUtils y especificar el departamento
        HospitalUtils.registerPatient("Cardiology");
        HospitalUtils.registerPatient("Neurology");

        // Mostrar el total de pacientes
        HospitalUtils.showTotalPatients();

        // Mostrar el conteo de pacientes por departamento
        HospitalUtils.showPatientCountByDepartment();

        System.out.println("Static methods called.\n");
    }
}
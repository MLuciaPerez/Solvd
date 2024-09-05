import Model.*;
import Model.Exceptions.*;
import Model.Interfaces.Diagnosable;
import Model.Interfaces.MedicationProvider;
import Model.Interfaces.Treatable;

import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Logger logger;
    public static void main(String[] args) {
        File log4j2File = new File("C:\\Users\\Lucia\\Documents\\GitHub\\Solvd\\src\\main\\resources\\log4j2.xml");
        System.setProperty("log4j2.configurationFile", log4j2File.toURI().toString());

        System.out.println("Creating Doctor and Nurse objects...");
        MedicalStaff doctor = new Doctor("Dr. Smith", 45, "D001", "Cardiology");
        MedicalStaff nurse = new Nurse("Nina Williams", 29, "N001", "Night");
        System.out.println("Doctor and Nurse objects created.\n");

        // Create Billing and Medication objects
        System.out.println("Creating Billing and Medication objects...");
        Billing billing = new Billing(null, 1500.00);
        ArrayList<Medication> medications = new ArrayList();
        medications.add(new Medication("Amoxicillin", "500mg"));
        medications.add(new Medication("Ibuprofen", "200mg"));
        System.out.println("Billing and Medication objects created.\n");

        // Instantiate a PatientZ object with Billing and Medications
        System.out.println("Instantiating Patient object...");
        Patient patient = new Patient("John Doe", 30, "P001", "Flu", billing, medications);
        System.out.println("PatientZ object instantiated.\n");

        // Link the Billing object back to the patient
        System.out.println("Linking Billing object back to the Patient...");
        billing.setPatient(patient);
        System.out.println("Billing object linked to Patient.\n");

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


        //   EXCEPTIONS

        // Create an instance of HospitalUtils
        HospitalUtils hospitalUtils = new HospitalUtils();
        System.out.println("\n");

        try {
            // Register patients in various departments
            HospitalUtils.registerPatient("Cardiology", "John Doe", 45);
            HospitalUtils.registerPatient("Neurology", "Jane Smith", 30);
            // Attempt to register a duplicate patient to trigger DuplicatePatientException
            HospitalUtils.registerPatient("Cardiology", "John Doe", 45);
        } catch (DepartmentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DuplicatePatientException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Display the total number of patients
        HospitalUtils.showTotalPatients();

        // Display the patient count by department
        HospitalUtils.showPatientCountByDepartment();

        // Process payment
        try {
            hospitalUtils.processPayment(150.00);  // Process a payment with a valid amount
            hospitalUtils.processPayment(-50.00); // Attempt to process a payment with an invalid amount to trigger an InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Accessing patients data
        try {
            hospitalUtils.accessPatientData(true);
            hospitalUtils.accessPatientData(false); // Attempt to access patient data without permission to trigger an UnauthorizedAccessException
        } catch (UnauthorizedAccessException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}
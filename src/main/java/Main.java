
import Model.Classes.*;
import Model.Enums.AppointmentStatus;
import Model.Enums.Department;
import Model.Enums.EquipmentType;
import Model.Enums.Specialty;
import Model.Exceptions.*;
import Model.Interfaces.Diagnosable;
import Model.Interfaces.MedicationProvider;
import Model.Interfaces.Treatable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

import java.util.*;
import java.util.function.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        File log4j2File = new File("C:\\Users\\Lucia\\Documents\\GitHub\\Solvd\\src\\main\\resources\\log4j2.xml");
        System.setProperty("log4j2.configurationFile", log4j2File.toURI().toString());

        logger.info("Creating Doctor and Nurse objects...");
        MedicalStaff doctor = new Doctor("Dr. Smith", 45, "D001", Specialty.CARDIOLOGY);
        MedicalStaff nurse = new Nurse("Nina Williams", 29, "N001", "Night", EquipmentType.STETHOSCOPE);
        logger.info("Doctor and Nurse objects created.\n");

        // Create Billing and Medication objects
        logger.info("Creating Billing and Medication objects...");
        Billing billing = new Billing(null, 1500.00);
        ArrayList<Medication> medications = new ArrayList<>();
        medications.add(new Medication("Amoxicillin", "500mg"));
        medications.add(new Medication("Ibuprofen", "200mg"));
        logger.info("Billing and Medication objects created.\n");

        // Instantiate a Patient object with Billing and Medications
        Patient patientInstance = new Patient("John Doe", 30, "P001", "Flu", billing, medications, AppointmentStatus.SCHEDULED);
        logger.info("Patient object instantiated.\n");

        // Link the Billing object back to the patient
        logger.info("Linking Billing object back to the Patient...");
        billing.setPatient(patientInstance);
        logger.info("Billing object linked to Patient.\n");

        // Demonstrate administrative management
        logger.info("Demonstrating administrative management...");
        Administrator admin = new Administrator("Alice Johnson", 50, Department.EMERGENCY);
        admin.manage();
        logger.info("Management demonstrated.\n");


        //LAMBDA FUNCTIONS
        Predicate<Patient> hasFlu = patient -> "Flu".equals(patient.getAilment());

        Function<Patient, Double> totalMedicationCost = patient -> {
            double total = 0;
            for (Medication medication : patient.getMedications()) {
                total += 50.00; // Assuming each medication costs 50.00
            }
            return total;
        };

        Consumer<Patient> printPatientDetails = patient -> logger.info("Patient: " + patient.getName() + ", Ailment: " + patient.getAilment());

        Supplier<Billing> billingSupplier = () -> new Billing(null, 1500.00);

        UnaryOperator<Double> applyDiscount = amount -> amount * 0.90; // Aplicar un descuento del 10%

        // Using the lambda functions
        logger.info("Patient has flu: " + hasFlu.test(patientInstance));

        logger.info("Total medication cost: " + totalMedicationCost.apply(patientInstance));

        printPatientDetails.accept(patientInstance);

        double amount = patientInstance.getBilling().getAmount();
        double discountedAmount = applyDiscount.apply(amount);
        logger.info("Discounted amount: " + discountedAmount);

        Billing billing1 = billingSupplier.get();
        logger.info("Billing object created using Supplier.\n");


        // Instantiate a Patient object with Billing and Medications
        Patient patient = new Patient("John Doe", 30, "P001", "Flu", billing, medications,AppointmentStatus.RESCHEDULED);

        // Test Custom Generic Lambda #1: applyFieldFunction
        logger.info("Testing applyFieldFunction...");
        String patientName = applyFieldFunction(Patient::getName, patient);
        logger.info("Patient name: " + patientName);

        // Test Custom Generic Lambda #2: processList
        logger.info("Testing processList...");
        processList(list -> list.forEach(med -> logger.info("Medication: " + med.getName() + ", Dosage: " + med.getDosage())), medications);

        // Test Custom Generic Lambda #3: compareObjects
        logger.info("Testing compareObjects...");
        // Compare the names of Doctor and Patient
        boolean areEqual = compareObjects((d, p) -> d.getName().equals(p.getName()), doctor, patient);
        logger.info("Are Doctor and Patient names the same? " + areEqual);

}

    // Method that applies a given function to an object of type T and returns a result of type R.
    public static <T, R> R applyFieldFunction(Function<T, R> function, T object) {
        // Applies the provided function to the given object and returns the result.
        return function.apply(object);
    }

    // Method that processes a list of type T using a given consumer.
    public static <T> void processList(Consumer<List<T>> consumer, List<T> list) {
        // Passes the provided list to the consumer for processing.
        consumer.accept(list);
    }

    // Method that compares two objects of type T and U using a given BiFunction and returns a result of type R.
    public static <T extends Person, U extends Person, R> R compareObjects(BiFunction<T, U, R> biFunction, T obj1, U obj2) {
        return biFunction.apply(obj1, obj2);
    }
}
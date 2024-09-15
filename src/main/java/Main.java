
import Model.Classes.*;
import Model.Enums.AppointmentStatus;
import Model.Enums.Department;
import Model.Enums.EquipmentType;
import Model.Enums.Specialty;
import Model.FunctionalInterfaces.Evaluator;
import Model.FunctionalInterfaces.Transformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

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
        Patient patientInstance = new Patient("Carlos Martin", 39, "P001", "Flu", billing, medications, AppointmentStatus.SCHEDULED);
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

        UnaryOperator<Double> applyDiscount = amount -> amount * 0.90;

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
        Patient patient = new Patient("John Smith", 30, "P002", "Flu", billing, medications,AppointmentStatus.RESCHEDULED);


        //Implementing lambda expressions for the functional generic interfaces Comparator, Evaluator, Transformer.

        // Lambda function to compare patients by age
        Comparator<Patient> compareByAge = (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge());
        int comparisonResult = compareByAge.compare(patientInstance, patient);
        logger.info("Comparison result: " + comparisonResult+"\n");

        // Lambda function to evaluate if a patient is an adult
        Evaluator<Patient, Boolean> isAdult = patientEv -> patient.getAge() >= 18;
        boolean adult = isAdult.evaluate(patientInstance);
        logger.info("Is patient an adult? " + adult +"\n");

        // Lambda function to get a patient’s details as a string
        Transformer<Patient, String> getPatientDetails = patientTr -> "Patient Name: " + patientTr.getName() + ", Age: " + patient.getAge();
        String details = getPatientDetails.transform(patient);
        logger.info(details);
}
}
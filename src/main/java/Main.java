
import Model.Classes.*;
import Model.Enums.AppointmentStatus;
import Model.Enums.Department;
import Model.Enums.EquipmentType;
import Model.Enums.Specialty;
import Model.FunctionalInterfaces.Evaluator;
import Model.FunctionalInterfaces.Transformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.reflect.*;

import java.io.File;

import java.time.LocalDate;
import java.util.*;
import java.util.function.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        File log4j2File = new File("C:\\Users\\Lucia\\Documents\\GitHub\\Solvd\\src\\main\\resources\\log4j2.xml");
        System.setProperty("log4j2.configurationFile", log4j2File.toURI().toString());

       List<Patient> patients= new ArrayList<>();
        logger.info("Creating Doctor and Nurse objects...");
        MedicalStaff doctor = new Doctor("Dr. Smith", 45, "D001", Specialty.CARDIOLOGY,patients);
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


        logger.info("LAMBDA FUNCTIONS"+"\n");

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


        logger.info("\n Implementing lambda expressions for the functional generic interfaces Comparator, Evaluator, Transformer \n");

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






        logger.info("\n");
        logger.info("Testing collection streaming in class Clinic");
        logger.info("CRATING OBJECTS");
        logger.info("\n");


        Clinic clinic = new Clinic("Solvd Clinic", "1234 Health St");

        ArrayList<Patient> patients1 = new ArrayList<>();
        Patient patient1=new Patient("Carla Perez", 34, "P001", "Headache", null, new ArrayList<>(), AppointmentStatus.SCHEDULED);
        patients1.add(patient1);
        Patient patient2=new Patient("Maria Gomez", 40, "P002", "Cold", null, new ArrayList<>(), AppointmentStatus.SCHEDULED);
        patients1.add(patient2);

        Doctor doctor1 = new Doctor("Dr. Miles", 45, "D001", Specialty.CARDIOLOGY, patients1);
        Doctor doctor2 = new Doctor("Dr. Williams", 38, "D002", Specialty.NEUROLOGY, new ArrayList<>());

        clinic.getDoctors().add(doctor1);
        clinic.getDoctors().add(doctor2);

        LocalDate appointmentDate = LocalDate.of(2024, 9, 15);
        LocalDate createdDate = LocalDate.now();

        Nurse nurse1 = new Nurse("Luna Jones", 29, "N001", "Night", EquipmentType.STETHOSCOPE);
        clinic.getNurses().add(nurse1);

        clinic.getDepartments().put("Cardiology", 10);
        clinic.getDepartments().put("Dermatology", 7);

        clinic.getAppointments().add(new Appointment(patients1.get(0), doctor1, LocalDate.of(2024, 9, 18), LocalDate.now(), 60));
        clinic.getAppointments().add(new Appointment(patients1.get(1), doctor2, LocalDate.of(2024, 9, 20), LocalDate.now(), 30));


        // Testing the Clinic Class methods

        // 1. Filter doctor with more than 5 patients
        logger.info("Experienced Doctors (more than 5 patients): " + clinic.getExperiencedDoctors());

        // 2. Sorted Patients by appointment date
        logger.info("Sorted Patients by appointment date: " + clinic.getSortedPatients());

        // 3. Counting total number of nurses
        logger.info("Total number of nurses: " + clinic.countNurses());

        // 4. Getting the department names in uppercase
        logger.info("Department names in uppercase: " + clinic.getDepartmentNamesInUppercase());

        // 5. Verify if a doctor has more than 10 patients
        logger.info("Are there busy doctors (more than 10 patients)?: " + clinic.hasBusyDoctors());

        // 6. Calculates the appointment duration
        logger.info("Total appointment duration: " + clinic.getTotalAppointmentDuration() + " minutes");

        // 7. Obtains the first patient in the queue
        Optional<Patient> firstPatient = clinic.getFirstPatient();
        logger.info("First patient in the queue: " + (firstPatient.isPresent() ? firstPatient.get().getName() : "No patients in the queue"));


        logger.info("\n");
        logger.info("REFLECTION");
        logger.info("\n");

        Class<?> appointmentClass = Appointment.class;
        // EXTRACTING INFO
        logger.info("Fields:");
        Field[] fields = appointmentClass.getDeclaredFields();
        for (Field field : fields) {
            logger.info("Name: " + field.getName());
            logger.info("Type: " + field.getType());
            logger.info("Modifiers: " + Modifier.toString(field.getModifiers()));
            logger.info("\n");
        }


        logger.info("Constructors:");
        Constructor<?>[] constructors = appointmentClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            logger.info("Constructor: " + constructor.getName());
            logger.info("Parameters: ");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> paramType : parameterTypes) {
                logger.info(paramType.getName());
            }
            logger.info("\n");
        }

        logger.info("Methods:");
        Method[] methods = appointmentClass.getDeclaredMethods();
        for (Method method : methods) {
            logger.info("Method: " + method.getName());
            logger.info("Return type: " + method.getReturnType().getName());
            logger.info("Modifiers: " + Modifier.toString(method.getModifiers()));
            logger.info("Parameters: ");
            Class<?>[] methodParams = method.getParameterTypes();
            for (Class<?> param : methodParams) {
                logger.info(param.getName());
            }
            logger.info("\n");
        }
    }


}
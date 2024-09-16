package Model.Classes;

import Model.Exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import java.util.stream.Collectors;

public class HospitalUtils {
    private static int totalPatients;
    private static HashMap<String, Integer> departmentPatientCount; //Map for patient count
    private static HashSet<String> registeredPatients = new HashSet<>(); // Set to keep track of registered patients.

    private static final Logger logger = LogManager.getLogger(HospitalUtils.class);


    static {
        logger.info("Static block in HospitalUtils class executed.");

        // Inicializar las variables estáticas
        departmentPatientCount = new HashMap<>();
        departmentPatientCount.put("Cardiology", 0);
        departmentPatientCount.put("Neurology", 0);
        departmentPatientCount.put("General", 0);

        logger.info("Patient department counts initialized.");
    }

    public HospitalUtils() {
        // Llamar al método de reinicio de variables estáticas
        resetVariables();
        logger.info("HospitalUtils instance created and variables reset.");
    }

    private void resetVariables() {
        totalPatients = 0;
        departmentPatientCount.clear();
        departmentPatientCount.put("Cardiology", 0);
        departmentPatientCount.put("Neurology", 0);
        departmentPatientCount.put("General", 0);
    }

    // Static method to register a patient with exception handling
    public static void registerPatient(String department, String patientName, int age) throws DepartmentNotFoundException, InvalidAgeException, DuplicatePatientException {
        if (department == null || !departmentPatientCount.containsKey(department)) {
            throw new DepartmentNotFoundException("Department not found: " + department);
        }
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative.");
        }
        if (registeredPatients.contains(patientName)) {
            throw new DuplicatePatientException("Patient " + patientName + " is already registered.");
        }
        totalPatients++;
        departmentPatientCount.put(department, departmentPatientCount.get(department) + 1);
        registeredPatients.add(patientName); // Add patient to the set
        logger.info("Patient registered: " + patientName + " in department: " + department + ", Age: " + age);

        // Try-with-resources
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter("src/patients.txt", true))) {
            writer.write("Patient registered: " + patientName + " in department: " + department + ", Age: " + age);
            writer.newLine();
        } catch (
                IOException e) {
            e.getMessage();
        }
    }

    // Method to process payment with exception handling
    public void processPayment(double amount) throws InsufficientFundsException {
        if (amount < 0) {
            throw new InsufficientFundsException("Insufficient funds to process the payment.");
        }
        logger.info("Payment processed: $" + amount);
    }


    // Method to access patient data
    public void accessPatientData(boolean hasPermission) throws UnauthorizedAccessException {
        if (!hasPermission) {
            throw new UnauthorizedAccessException("Unauthorized access to patient data.");
        }
        logger.info("Patient data accessed successfully.");
    }

    public static void showTotalPatients() {
        logger.info("Total number of patients: " + totalPatients);
    }

    public static void showPatientCountByDepartment() {
        logger.info("Patient count by department:");
        for (HashMap.Entry<String, Integer> entry : departmentPatientCount.entrySet()) {
            logger.info(entry.getKey() + ": " + entry.getValue());
        }
    }
}

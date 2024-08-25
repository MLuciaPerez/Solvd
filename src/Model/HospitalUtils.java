package Model;

import Model.Exceptions.*;

import java.util.HashMap;
import java.util.HashSet;

public class HospitalUtils {
    private static int totalPatients;
    private static HashMap<String, Integer> departmentPatientCount;
    private static HashSet<String> registeredPatients = new HashSet<>(); // Set to keep track of registered patients


    static {
        System.out.println("Static block in HospitalUtils class executed.");

        // Inicializar las variables estáticas
        departmentPatientCount = new HashMap<>();
        departmentPatientCount.put("Cardiology", 0);
        departmentPatientCount.put("Neurology", 0);
        departmentPatientCount.put("General", 0);

        System.out.println("Patient department counts initialized.");
    }

    public HospitalUtils() {
        // Llamar al método de reinicio de variables estáticas
        resetVariables();
        System.out.println("HospitalUtils instance created and variables reset.");
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
        System.out.println("Patient registered: " + patientName + " in department: " + department + ", Age: " + age);
    }


    // Method to process payment with exception handling
    public void processPayment(double amount) throws InsufficientFundsException {
        if (amount < 0) {
            throw new InsufficientFundsException("Insufficient funds to process the payment.");
        }
        System.out.println("Payment processed: $" + amount);
    }


    // Method to access patient data
    public void accessPatientData(boolean hasPermission) throws UnauthorizedAccessException {
        if (!hasPermission) {
            throw new UnauthorizedAccessException("Unauthorized access to patient data.");
        }
        System.out.println("Patient data accessed successfully.");
    }

    public static void showTotalPatients() {
        System.out.println("Total number of patients: " + totalPatients);
    }

    public static void showPatientCountByDepartment() {
        System.out.println("Patient count by department:");
        for (HashMap.Entry<String, Integer> entry : departmentPatientCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

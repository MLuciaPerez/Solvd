package Model;

import java.util.HashMap;

public class HospitalUtils {
    private static int totalPatients;
    private static HashMap<String, Integer> departmentPatientCount;

    // Bloque estático para inicialización global
    static {
        System.out.println("Static block in HospitalUtils class executed.");

        // Inicializar las variables estáticas
        departmentPatientCount = new HashMap<>();
        departmentPatientCount.put("Cardiology", 0);
        departmentPatientCount.put("Neurology", 0);
        departmentPatientCount.put("General", 0);

        System.out.println("Patient department counts initialized.");
    }

    // Constructor de la clase HospitalUtils
    public HospitalUtils() {
        // Llamar al método de reinicio de variables estáticas
        resetVariables();
        System.out.println("HospitalUtils instance created and variables reset.");
    }

    // Método de instancia para reiniciar las variables estáticas
    private void resetVariables() {
        totalPatients = 0;
        departmentPatientCount.clear();
        departmentPatientCount.put("Cardiology", 0);
        departmentPatientCount.put("Neurology", 0);
        departmentPatientCount.put("General", 0);
    }

    // Método estático para registrar un nuevo paciente y actualizar el conteo
    public static void registerPatient(String department) {
        totalPatients++;
        departmentPatientCount.put(department, departmentPatientCount.getOrDefault(department, 0) + 1);
        System.out.println("A new patient has been registered in " + department + ". Total patients: " + totalPatients);
    }

    // Método estático para mostrar el total de pacientes
    public static void showTotalPatients() {
        System.out.println("Total number of patients: " + totalPatients);
    }

    // Método estático para mostrar el conteo de pacientes por departamento
    public static void showPatientCountByDepartment() {
        System.out.println("Patient count by department:");
        for (HashMap.Entry<String, Integer> entry : departmentPatientCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

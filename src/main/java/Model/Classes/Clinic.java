package Model.Classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class Clinic {

    private static final Logger logger = LogManager.getLogger(Clinic.class);
    private String name;
    private String address;
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private HashSet<Nurse> nurses = new HashSet<>();
    private HashMap<String, Integer> departments = new HashMap<>();
    private TreeSet<Appointment> appointments = new TreeSet<>();
    private LinkedList<Patient> patientsQueue = new LinkedList<>();


    // Constructor
    public Clinic(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HashMap<String, Integer> getDepartments() {
        return departments;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public HashSet<Nurse> getNurses() {
        return nurses;
    }

    public TreeSet<Appointment> getAppointments() {
        return appointments;
    }

    public LinkedList<Patient> getPatientsQueue() {
        return patientsQueue;
    }

    // Non-terminal operation: Filtering doctors with more than 5 patients.
    public List<Doctor> getExperiencedDoctors() {
        return doctors.stream()
                .filter(doctor -> doctor.getPatients().size() > 5) // Non-terminal operation
                .collect(Collectors.toList()); // Terminal operation
    }

    // Non-terminal operation: Sorting patients by appointment date.
    public List<Patient> getSortedPatients() {
        return patientsQueue.stream()
                .sorted(Comparator.comparing(patient -> patient.getAppointmentDates().isEmpty()
                        ? null : patient.getAppointmentDates().first(), Comparator.nullsLast(Comparator.naturalOrder()))) // Non-terminal
                .collect(Collectors.toList()); // Terminal
    }

    // Non-terminal operation: Counting total nurses in the system.
    public long countNurses() {
        return nurses.stream().count(); // Terminal operation
    }

    // Non-terminal operation: Mapping department names to uppercase.
    public List<String> getDepartmentNamesInUppercase() {
        return departments.keySet().stream()
                .map(String::toUpperCase) // Non-terminal operation
                .collect(Collectors.toList()); // Terminal operation
    }

    // Terminal operation: Checking if any doctor has more than 10 patients.
    public boolean hasBusyDoctors() {
        return doctors.stream()
                .anyMatch(doctor -> doctor.getPatients().size() > 10); // Terminal operation
    }

    // Non-terminal operation: Reducing appointments to calculate total duration.
    public int getTotalAppointmentDuration() {
        return appointments.stream()
                .map(Appointment::getDuration) // Non-terminal
                .reduce(0, Integer::sum); // Terminal operation (reduce)
    }

    // Terminal operation: Getting the first patient in the queue.
    public Optional<Patient> getFirstPatient() {
        return patientsQueue.stream().findFirst(); // Terminal operation
    }

    @Override
    public String toString() {
        return "Clinic: Name=" + name + ", Address=" + address;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + address.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Clinic clinic = (Clinic) obj;
        return name.equals(clinic.name) && address.equals(clinic.address);
    }
}
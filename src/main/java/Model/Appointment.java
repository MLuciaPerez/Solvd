package Model;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String appointmentDate;

    // Constructor
    public Appointment(Patient patient, Doctor doctor, String appointmentDate) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
    }

    // Getter and Setter for patient
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // Getter and Setter for doctor
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    // Getter and Setter for appointmentDate
    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public String toString() {
        return "Appointment: Patient=" + patient.getName() + ", Doctor=" + doctor.getName() + ", Date=" + appointmentDate;
    }

    @Override
    public int hashCode() {
        return patient.hashCode() + doctor.hashCode() + appointmentDate.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Appointment appointment = (Appointment) obj;
        return patient.equals(appointment.patient) && doctor.equals(appointment.doctor) && appointmentDate.equals(appointment.appointmentDate);
    }
}
package Model.Classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public class Appointment implements Comparable<Appointment>{
    private static final Logger logger = LogManager.getLogger(Appointment.class);
    private Patient patient;
    private Doctor doctor;
    private  LocalDate appointmentDate;
    private LocalDate Date;
    private int duration; // Add duration attribute


    // Constructor
    public Appointment(Patient patient, Doctor doctor, LocalDate appointmentDate,LocalDate date, int duration) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.Date = date;
        this.duration = duration;

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


    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public int getDuration() {
        return duration;
    }

    // Other methods related to Appointment...

    public int compareTo(Appointment other) {
        // Ordenar por fecha de la cita
        return this.appointmentDate.compareTo(other.appointmentDate);
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
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
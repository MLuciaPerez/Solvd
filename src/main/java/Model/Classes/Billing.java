package Model.Classes;

import Model.Interfaces.Payable;

public class Billing implements Payable {
    private Patient patient;
    protected double amount;  // Protected modifier

    // Constructor
    public Billing(Patient patient, double amount) {
        this.patient = patient;
        this.amount = amount;
    }

    // Implement Payable interface method
    public void processPayment() {
        System.out.println("Processing payment of $" + amount + " for patient: " + (patient != null ? patient.getName() : "Unknown"));
    }

    // Getter and Setter for patient
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // Getter and Setter for amount
    public double getAmount() {
        return amount;
    }

    // Override toString() method from Object class
    @Override
    public String toString() {
        return "Billing Amount: $" + amount;
    }

    // Override hashCode() method from Object class
    @Override
    public int hashCode() {
        return Double.hashCode(amount) + (patient != null ? patient.hashCode() : 0);
    }

    // Override equals() method from Object class
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Billing billing = (Billing) obj;
        return Double.compare(billing.amount, amount) == 0 && (patient != null ? patient.equals(billing.patient) : billing.patient == null);
    }
}
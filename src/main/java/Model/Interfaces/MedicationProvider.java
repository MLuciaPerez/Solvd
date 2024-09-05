package Model.Interfaces;

import Model.Patient;

public interface MedicationProvider {
    void prescribeMedication(Patient patient, String medication, String dosage);
}
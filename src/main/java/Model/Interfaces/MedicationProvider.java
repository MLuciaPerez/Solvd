package Model.Interfaces;

import Model.Classes.Patient;

public interface MedicationProvider {
    void prescribeMedication(Patient patient, String medication, String dosage);
}
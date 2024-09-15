package Model.Classes;

public class Medication {
    protected String name;    // Protected modifier
    protected String dosage;  // Protected modifier

    // Constructor
    public Medication(String name, String dosage) {
        this.name = name;
        this.dosage = dosage;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for dosage
    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    // Override toString() method from Object class
    @Override
    public String toString() {
        return "Medication: " + name + ", Dosage: " + dosage;
    }

    // Override hashCode() method from Object class
    @Override
    public int hashCode() {
        return name.hashCode() + dosage.hashCode();
    }

    // Override equals() method from Object class
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Medication that = (Medication) obj;
        return name.equals(that.name) && dosage.equals(that.dosage);
    }
}
package Model.Classes;

public class Clinic {
    private String name;
    private String address;

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
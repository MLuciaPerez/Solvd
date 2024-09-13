package Model.Enums;

public enum EquipmentType {
    STETHOSCOPE("Essential"),
    SYRINGE("Disposable"),
    OXYGEN_MASK("Critical"),
    DEFIBRILLATOR("Life-saving"),
    THERMOMETER("Basic");

    private String description;

    EquipmentType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
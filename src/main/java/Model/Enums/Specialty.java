package Model.Enums;

public enum Specialty {
    CARDIOLOGY("High complexity"),
    DERMATOLOGY("Medium complexity"),
    PEDIATRICS("Low complexity"),
    NEUROLOGY("High complexity"),
    GYNECOLOGY("Medium complexity");

    private String complexityLevel;

    Specialty(String complexityLevel) {
        this.complexityLevel = complexityLevel;
    }

    public String getComplexityLevel() {
        return complexityLevel;
    }
}
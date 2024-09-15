package Model.Enums;

public enum PriorityLevel {
    HIGH("High priority"),
    MEDIUM("Medium priority"),
    LOW("Low priority");

    private String description;

    PriorityLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

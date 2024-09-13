package Model.Enums;

public enum AppointmentStatus {
    SCHEDULED("Scheduled"),
    COMPLETED("Completed"),
    CANCELED("Canceled"),
    RESCHEDULED("Rescheduled");

    private String description;

    AppointmentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
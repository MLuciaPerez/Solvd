package Model.Enums;

public enum Department {
    SURGERY("S01"),
    EMERGENCY("E02"),
    PEDIATRICS("P03"),
    ONCOLOGY("O04"),
    CARDIOLOGY("C05");

    private String code;

    Department(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
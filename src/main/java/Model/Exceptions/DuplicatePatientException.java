package Model.Exceptions;

public class DuplicatePatientException extends Exception {
    public DuplicatePatientException(String message) {
        super(message);
    }
}
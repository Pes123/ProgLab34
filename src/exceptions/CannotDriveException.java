package exceptions;

public class CannotDriveException extends RuntimeException {
    public CannotDriveException(String message) {
        super(message);
    }
}

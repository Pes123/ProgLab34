package exceptions;

public class DoorIsntOpenException extends RuntimeException {
    public DoorIsntOpenException(String message) {
        super(message);
    }
}

package exceptions;

public class DoorIsntOpenException extends RuntimeException {
    public DoorIsntOpenException() {
        super("Дверь закрыта блинб");
    }
}

package exceptions;

public class ThereIsNoCarException extends RuntimeException {
    public ThereIsNoCarException(String message) {
        super(message);
    }
}

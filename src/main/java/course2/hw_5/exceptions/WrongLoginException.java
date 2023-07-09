package course2.hw_5.exceptions;

public class WrongLoginException extends Throwable {
    public WrongLoginException(String message) {
        super(message);
    }
}

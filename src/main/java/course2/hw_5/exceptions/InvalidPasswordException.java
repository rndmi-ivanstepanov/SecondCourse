package course2.hw_5.exceptions;

public class InvalidPasswordException extends Throwable {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

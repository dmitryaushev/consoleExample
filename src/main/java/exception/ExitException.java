package exception;

public class ExitException extends RuntimeException{
    public ExitException(String message) {
        super(message);
    }
}

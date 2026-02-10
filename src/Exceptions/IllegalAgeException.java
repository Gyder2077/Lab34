package Exceptions;

public class IllegalAgeException extends RuntimeException {
    public IllegalAgeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {return super.getMessage() + "!";}
}

package Exceptions;

public class IllegalUsefullnessException extends Exception {
    public IllegalUsefullnessException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {return super.getMessage() + "!";}
}

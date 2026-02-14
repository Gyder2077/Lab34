package Exceptions;

public class GettingItemException extends RuntimeException {
    public GettingItemException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {return super.getMessage() + "!";}
}

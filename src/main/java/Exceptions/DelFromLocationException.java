package Exceptions;

public class DelFromLocationException extends RuntimeException {
    public DelFromLocationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {return super.getMessage() + "!";}
}

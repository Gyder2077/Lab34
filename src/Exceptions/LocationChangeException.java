package Exceptions;

public class LocationChangeException extends RuntimeException {
    public LocationChangeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {return super.getMessage() + "!";}
}

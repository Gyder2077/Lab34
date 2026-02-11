package Exceptions;

public class MovingToWardrobeException extends RuntimeException {
    public MovingToWardrobeException(String message) {super(message);}

    @Override
    public String getMessage() {return super.getMessage() + "!";}
}

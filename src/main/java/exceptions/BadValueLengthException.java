package exceptions;

public class BadValueLengthException extends Exception {
    private static final String message = "Длина должна быть не меньше";

    public BadValueLengthException(int length) {
        super(message + " " + length);
    }
}

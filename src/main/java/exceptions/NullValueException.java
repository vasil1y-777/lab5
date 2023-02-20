package exceptions;

public class NullValueException extends Exception {
    private static final String message = "Это обязательное поле";

    public NullValueException() {
        super(message);
    }
}

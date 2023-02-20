package exceptions;

public class BlankValueException extends Exception {
    private static final String message = "Введённое значение не может быть пустой строкой";

    public BlankValueException() {
        super(message);
    }
}

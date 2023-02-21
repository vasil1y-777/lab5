package exceptions;

public class NotGreatThanException extends Exception {
    private static final String message = "Введённое значение должно быть больше";

    public NotGreatThanException(int bound) {
        super(message + " " + bound);
    }
}

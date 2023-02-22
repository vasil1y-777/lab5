package exceptions;

public class NotGreatThanException extends WarningException {
    private final int bound;

    public NotGreatThanException(int bound) {
        this.bound = bound;
    }

    @Override
    public String getMessage() {
        return "Введённое значение должно быть больше " + bound;
    }
}

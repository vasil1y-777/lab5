package exceptions;

public class DangerException extends Exception {
    private static final String COLOR_RESET = "\u001B[0m";
    private static final String COLOR_RED = "\u001B[31m";
    private String message = "";

    public DangerException() {
    }

    public DangerException(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(COLOR_RED + getMessage() + COLOR_RESET);
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return COLOR_RED + getMessage() + COLOR_RESET;
    }
}

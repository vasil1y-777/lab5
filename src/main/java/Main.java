import exceptions.DangerException;
import exceptions.NoSuchCommandException;
import exceptions.SystemException;
import interfaces.Command;

import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static final String COLOR_RESET = "\u001B[0m";
    private static final String COLOR_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler();
        while (true) {
            System.out.print(COLOR_GREEN + "> " + COLOR_RESET);
            try {
                String commandName = scanner.nextLine();
                if (!commandName.isBlank()) {
                    Command command = inputHandler.getCommand(commandName);
                    command.execute();
                }
            } catch (NoSuchCommandException e) {
                e.printMessage();
            } catch (NoSuchMethodException | InvocationTargetException |
                     InstantiationException | IllegalAccessException e) {
                new SystemException().printMessage();
            } catch (NoSuchElementException e) {
                new DangerException("Для безопасного выхода используйте команду " + COLOR_GREEN + "exit" + COLOR_RESET).printMessage();
                Runtime.getRuntime().exit(0);
            }
        }
    }
}

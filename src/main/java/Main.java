import classes.console.InputHandler;
import classes.console.TextColor;
import exceptions.NoSuchCommandException;
import exceptions.SystemException;
import interfaces.Command;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler();
        while (true) {
            System.out.print(TextColor.green("> "));
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
            }
        }
    }
}

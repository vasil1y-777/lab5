import classes.console.InputHandler;
import classes.console.TextColor;
import exceptions.NoSuchCommandException;
import exceptions.SystemException;
import interfaces.Commandable;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler();
        while (true) {
            System.out.print(TextColor.green("> "));
            try {
                String inputString = scanner.nextLine();
                String commandName = inputString.split(" ")[0];
                String commandArgument = inputString.split(" ")[1];
                if (!commandName.isBlank()) {
                    Commandable command = inputHandler.getCommand(commandName);
                    command.execute(commandArgument);
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

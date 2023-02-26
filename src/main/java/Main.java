import exceptions.DangerException;
import exceptions.NoSuchCommandException;
import exceptions.SystemException;
import helper.ColorTextBuilder;
import helper.InputHandler;
import interfaces.Command;

import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler();
        while (true) {
            ColorTextBuilder.printConsoleLine("> ");
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
                new DangerException("Для безопасного выхода используйте команду " + ColorTextBuilder.getConsoleLine("exit")).printMessage();
                Runtime.getRuntime().exit(0);
            }
        }
    }
}

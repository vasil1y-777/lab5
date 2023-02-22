package classes.console;

import exceptions.NoSuchCommandException;
import interfaces.Command;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class InputHandler {
    private final Set<Class<? extends Command>>
            allCommands = new Reflections("classes.commands").getSubTypesOf(Command.class);

    public Command getCommand(String commandName) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchCommandException {
        commandName = commandName.trim().substring(0, 1).toUpperCase() + commandName.trim().toLowerCase().substring(1);
        for (Class<? extends Command> command : allCommands) {
            if (command.getName().equals("classes.commands." + commandName))
                return command.getDeclaredConstructor().newInstance();
        }
        throw new NoSuchCommandException();
    }
}

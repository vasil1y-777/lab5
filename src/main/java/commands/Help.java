package commands;

import interfaces.Command;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class Help implements Command {
    @Override
    public void execute() {
        Reflections reflections = new Reflections("commands");
        Set<Class<? extends Command>> allCommands = reflections.getSubTypesOf(Command.class);
        for (Class<? extends Command> command : allCommands) {
            try {
                System.out.println(command.getDeclaredConstructor().newInstance().getInfo());
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getInfo() {
        return getName() + "\t-\tвывести справку по доступным командам";
    }
}

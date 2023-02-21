package commands;

import interfaces.Command;
import org.reflections.Reflections;

import java.util.Set;

public class Help implements Command {
    @Override
    public void execute() {
        Reflections reflections = new Reflections("commands");
        Set<Class<? extends Command>> allCommands = reflections.getSubTypesOf(Command.class);
        for (Class<? extends Command> command : allCommands) {
            try {
                System.out.println(command.newInstance().getInfo());
            } catch (IllegalAccessException | InstantiationException e) {
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

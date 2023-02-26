package classes.console;

import exceptions.NoSuchCommandException;
import interfaces.Commandable;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class InputHandler {
    private final Set<Class<? extends Commandable>>
            allCommands = new Reflections("classes.commands").getSubTypesOf(Commandable.class);

    public Commandable getCommand(String commandName) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchCommandException {
        for (Class<? extends Commandable> command : allCommands) {
            if (camelToSnake(command.getName().split("\\.")[2]).equals(commandName))
                return command.getDeclaredConstructor().newInstance();
        }
        throw new NoSuchCommandException();
    }

    public static String camelToSnake(String str) {
        String result = str.substring(0, 1).toLowerCase();
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch))
                result += "_" + Character.toLowerCase(ch);
            else result += ch;
        }
        return result;
    }
}

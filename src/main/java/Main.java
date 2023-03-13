import classes.collection.CollectionManager;
import classes.console.CommandHandler;
import classes.console.TextColor;
import classes.movie.Movie;
import classes.xml_manager.XMLMovieManager;
import exceptions.NoSuchCommandException;
import exceptions.SystemException;
import interfaces.Commandable;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandHandler commandHandler = new CommandHandler();
        System.out.println(TextColor.purple("Пытаюсь прочитать файл коллекции..."));

        if (args.length == 1) {
            CollectionManager cm = new CollectionManager();
            for (Movie movie : XMLMovieManager.getInstance().readCollectionFromXML(args[0]).getMovies()) {
                cm.addMovie(movie);
            }
        } else {
            System.out.println(TextColor.purple("Провал\nВводите в аргументы программы только одно слово - имя файла с расширением"));
            Runtime.getRuntime().exit(0);
        }

        while (true) {
            System.out.print(TextColor.green("> "));
            try {
                String inputString = scanner.nextLine();
                String commandName = inputString.split(" ")[0];
                String commandArgument = null;
                if (inputString.split(" ").length > 1) {
                    commandArgument = inputString.split(" ")[1];
                }
                if (!commandName.isBlank()) {
                    Commandable command = commandHandler.getCommand(commandName);
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

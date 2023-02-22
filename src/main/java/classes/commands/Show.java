package classes.commands;

import classes.collection.CollectionManager;
import classes.console.TextColor;
import classes.movie.Movie;
import interfaces.Command;

import java.util.ArrayList;

public class Show implements Command {
    @Override
    public void execute() {
        System.out.println(TextColor.cyan("Содержимое коллекции:"));
        CollectionManager collectionManager = new CollectionManager();
        ArrayList<Movie> movies = collectionManager.getCollection();
        if (movies.size() != 0)
            for (Movie movie : movies)
                System.out.println("\t" + movie.toString());
        else System.out.println(TextColor.cyan("\tПусто"));
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getInfo() {
        return getName() + "\t-\tвывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}

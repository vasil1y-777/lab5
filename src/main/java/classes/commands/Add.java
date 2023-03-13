package classes.commands;

import classes.NamedCommand;
import classes.collection.CollectionManager;
import classes.console.InputHandler;
import classes.movie.Movie;
import interfaces.Commandable;

public class Add extends NamedCommand implements Commandable {
    @Override
    public String getInfo() {
        return getName() + "\t\t-\tдобавить новый элемент в коллекцию";
    }

    @Override
    public void execute(String... args) {
        CollectionManager collectionManager = new CollectionManager();
        InputHandler inputHandler = new InputHandler();
        Movie movie = inputHandler.readMovie();
        collectionManager.addMovie(movie);
    }
}

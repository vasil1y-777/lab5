package classes.commands;

import classes.NamedCommand;
import classes.collection.CollectionManager;
import interfaces.Commandable;

public class Clear extends NamedCommand implements Commandable {

    @Override
    public void execute(String... args) {
        new CollectionManager().clear();
    }

    @Override
    public String getInfo() {
        return getName() + "\t-\tочистить коллекцию";

    }
}


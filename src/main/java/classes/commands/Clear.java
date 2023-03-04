package classes.commands;

import classes.DataStorage;
import classes.collection.CollectionManager;
import interfaces.Commandable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Clear implements Commandable {

    @Override
    public void execute(String... args) {
        new CollectionManager().clear();
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getInfo() {
        return getName() + "\t-\tочистить коллекцию";

    }
}


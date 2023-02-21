package commands;

import interfaces.Command;

public class Exit implements Command {
    @Override
    public void execute() {
        Runtime.getRuntime().exit(0);
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getInfo() {
        return getName() + "\t-\tзавершить программу (без сохранения в файл)";
    }
}

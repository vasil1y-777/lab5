package classes;

import classes.console.InputHandler;

public abstract class NamedCommand {
    public String getName() {
        return InputHandler.camelToSnake(this.getClass().getSimpleName());
    }
}

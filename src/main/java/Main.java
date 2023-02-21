import commands.Help;
import interfaces.Command;

public class Main {
    public static void main(String[] args) {
        Command help = new Help();
        help.execute();
    }
}

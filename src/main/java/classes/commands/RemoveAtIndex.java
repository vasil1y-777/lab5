package classes.commands;

import classes.collection.CollectionManager;
import classes.console.TextColor;
import interfaces.Commandable;

public class RemoveAtIndex implements Commandable {
    @Override
    public String getName() {
        return "remove_at_index";
    }

    @Override
    public String getInfo() {
        return getName() + "\t-\tудалить элемент, находящийся в заданной позиции коллекции (index)";
    }

    @Override
    public void execute(String... args) {
        if (args.length == 1) {
            try{
                int idx = Integer.parseInt(args[0]);
                new CollectionManager().getCollection().remove(idx);
            } catch (NumberFormatException e){
                System.out.println(TextColor.yellow("Неверный формат ввода. Введите индекс в формате целочисленного числа через пробел"));
            }
            finally {
                System.out.println(TextColor.cyan("Элемент успешно удалён"));
            }

        } else {
            System.out.println(TextColor.yellow("Неверный формат ввода. Введите индекс в формате целочисленного числа через пробел"));
        }

    }
}

package classes.movie;

import exceptions.*;

import java.util.Random;

public class RandomMovie {

    public static Movie generate() {
        Random r = new Random();

        Person director = null;
        try {
            director = new Person(
                    "Director" + r.nextInt(100),
                    null,
                    null,
                    "1234567",
                    Color.BROWN);
            Movie m = new Movie(
                    "Name" + r.nextInt(100),
                    new Coordinates(r.nextInt(278), r.nextInt(1000) - 230),
                    null,
                    null,
                    null,
                    null,
                    director);
            m.setBudget((float) r.nextInt(10000));
            return m;
        } catch (BlankValueException | NullValueException | NotGreatThanException | BadValueLengthException |
                 GreatThanException | NotUniqueException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}

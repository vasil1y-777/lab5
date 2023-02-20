package movie;

import exceptions.NotGreatThanException;
import exceptions.NullValueException;

import static movie.FieldProperty.GREAT_THAN_X;
import static movie.FieldProperty.MAX_VALUE;

public class Coordinates {
    private long x; //Максимальное значение поля: 279
    private int y; //Значение поля должно быть больше -230

    Coordinates(long x, int y) throws NotGreatThanException, NullValueException {
        this.x = new FieldHandler(x, MAX_VALUE).handleLong();
        this.y = new FieldHandler(y, GREAT_THAN_X).handleInt();
    }
}

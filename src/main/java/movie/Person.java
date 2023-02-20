package movie;

import exceptions.BadValueLengthException;
import exceptions.BlankValueException;
import exceptions.NotGreatThanException;
import exceptions.NullValueException;

import java.util.Date;

import static movie.FieldProperty.*;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Date birthday; //Поле может быть null
    private Double height; //Поле может быть null, Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Длина строки должна быть не меньше 7, Строка не может быть пустой, Поле не может быть null
    private Color eyeColor; //Поле не может быть null

    protected Person(String name, Date birthday, Double height, String passportID, Color eyeColor) throws BlankValueException, NullValueException, NotGreatThanException, BadValueLengthException {
        this.name = new FieldHandler(name, NOT_NULL, NOT_BLANK).handleString();
        this.birthday = birthday;
        this.height = new FieldHandler(height, NOT_NULL).handleDouble();
        this.passportID = new FieldHandler(passportID, UNIQUE, LENGTH, NOT_BLANK, NOT_NULL).handleString();
    }
}

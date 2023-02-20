package movie;

import exceptions.BadValueLengthException;
import exceptions.BlankValueException;
import exceptions.NotGreatThanException;
import exceptions.NullValueException;

import java.util.Date;
import java.util.UUID;

import static movie.FieldProperty.*;

public class Movie {
    private UUID id; //(UUID) Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long oscarsCount; //Значение поля должно быть больше 0
    private long goldenPalmCount; //Значение поля должно быть больше 0
    private Float budget; //Значение поля должно быть больше 0, Поле может быть null
    private MpaaRating mpaaRating; //Поле может быть null
    private Person director; //Поле не может быть null

    public Movie(String name,
                 Coordinates coordinates,
                 long oscarsCount,
                 long goldenPalmCount,
                 Float budget,
                 MpaaRating mpaaRating,
                 Person director) throws BlankValueException, NullValueException, NotGreatThanException, BadValueLengthException {
        id = java.util.UUID.randomUUID();
        this.name = new FieldHandler(name, NOT_NULL, NOT_BLANK).handleString();
        this.coordinates = new FieldHandler(coordinates, NOT_NULL).handleCoordinates();
        creationDate = new Date();
        this.oscarsCount = new FieldHandler(oscarsCount, GREAT_THAN_ZERO).handleLong();
        this.goldenPalmCount = new FieldHandler(goldenPalmCount, GREAT_THAN_ZERO).handleLong();
        this.budget = new FieldHandler(budget, GREAT_THAN_ZERO).handleFloat();
        this.mpaaRating = mpaaRating;
        this.director = new FieldHandler(director, NOT_NULL).handlePerson();
    }


}


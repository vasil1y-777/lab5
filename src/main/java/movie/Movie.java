package movie;


import exceptions.BadValueLengthException;
import exceptions.BlankValueException;
import exceptions.NotGreatThanException;
import exceptions.NullValueException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.UUID;

import static movie.FieldProperty.*;

/**
 * Model of Movie. Sub-model of the <code>Route</code>. Contains getters/setters of each class fields.
 * Some fields have restrictions. It's signed under every method of field.
 */
@XmlRootElement(name = "movie")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie {
    //TODO перенести javadoc с геттеров-сеттеров только на поля
    private UUID id; //(UUID) Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long oscarsCount; //Значение поля должно быть больше 0
    private Long goldenPalmCount; //Значение поля должно быть больше 0
    private Float budget; //Значение поля должно быть больше 0, Поле может быть null
    private MpaaRating mpaaRating; //Поле может быть null
    private Person director; //Поле не может быть null

    public Movie(String name,
                 Coordinates coordinates,
                 Long oscarsCount,
                 Long goldenPalmCount,
                 Float budget,
                 MpaaRating mpaaRating,
                 Person director) throws BlankValueException, NullValueException, NotGreatThanException, BadValueLengthException {
        id = java.util.UUID.randomUUID();
        this.name = new FieldHandler(name, NOT_NULL, NOT_BLANK).handleString();
        this.coordinates = (Coordinates) new FieldHandler(coordinates, NOT_NULL).handleObject();
        creationDate = new Date();
        this.oscarsCount = new FieldHandler(oscarsCount, GREAT_THAN_ZERO).handleLong();
        this.goldenPalmCount = new FieldHandler(goldenPalmCount, GREAT_THAN_ZERO).handleLong();
        this.budget = new FieldHandler(budget, GREAT_THAN_ZERO).handleFloat();
        this.mpaaRating = mpaaRating;
        this.director = (Person) new FieldHandler(director, NOT_NULL).handleObject();
    }

    /**
     * Restrictions:  Value must be more than zero
     *
     * @return Value of field id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Restrictions:  Field cannot be null or empty string
     *
     * @return Value of field name
     */
    public String getName() {
        return name;
    }

    /**
     * Restrictions:  Field cannot be null
     *
     * @return Value of field coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Restrictions: Field should be unique & generating automatically
     *
     * @param coordinates Value of field coordinates
     */

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Restrictions:  Field cannot be null, value should generate automatically
     *
     * @return Value of field creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Restrictions: Field should be unique & generating automatically
     *
     * @param creationDate Value of field creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Restrictions:  Field should be greater than zero
     *
     * @return Value of field creationDate
     */
    public Long getOscarsCount() {
        return oscarsCount;
    }

    /**
     * Restrictions: Field should be greater than zero
     *
     * @param oscarsCount Value of field oscarsCount
     */
    public void setOscarsCount(long oscarsCount) {
        this.oscarsCount = oscarsCount;
    }

    /**
     * Restrictions: Field should be greater than zero
     *
     * @return Value of field goldenPalmCount
     */
    public Long getGoldenPalmCount() {
        return goldenPalmCount;
    }

    /**
     * Restrictions: Field should be greater than zero
     *
     * @param goldenPalmCount Value of field goldenPalmCount
     */
    public void setGoldenPalmCount(long goldenPalmCount) {
        this.goldenPalmCount = goldenPalmCount;
    }

    /**
     * Restrictions: Field should be greater than zero & cannot be null
     *
     * @return Value of field budget
     */
    public Float getBudget() {
        return budget;
    }

    /**
     * Restrictions: Field should be greater than zero
     *
     * @param budget Value of field goldenPalmCount
     */
    public void setBudget(Float budget) {
        this.budget = budget;
    }

    /**
     * Restrictions:  Field can be null
     *
     * @return Value of field mpaaRating
     */
    public MpaaRating getMpaaRating() {
        return mpaaRating;
    }

    /**
     * Restrictions: Field should be greater than zero
     *
     * @param mpaaRating Value of field mpaaRating
     */
    public void setMpaaRating(MpaaRating mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    /**
     * Restrictions:  Field cannot be null
     *
     * @return Value of field director
     */
    public Person getDirector() {
        return director;
    }

    /**
     * Restrictions: Field cannot be null
     *
     * @param director Value of field director
     */
    public void setDirector(Person director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", oscarsCount=" + oscarsCount +
                ", goldenPalmCount=" + goldenPalmCount +
                ", budget=" + budget +
                ", mpaaRating=" + mpaaRating +
                ", director=" + director +
                '}';
    }
}


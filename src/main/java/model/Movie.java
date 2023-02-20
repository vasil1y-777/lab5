package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

/**
 * Model of Movie. Sub-model of the <code>Route</code>. Contains getters/setters of each class fields.
 * Some fields have restrictions. It's signed under every method of field.
 */
//
@XmlRootElement(name = "movie")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie {
    //TODO перенести javadoc с геттеров-сеттеров только на поля
    /**
     * Restrictions:  Value must be more than zero
     *
     * @return Value of field id
     */
    private long id;
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int oscarsCount; //Значение поля должно быть больше 0
    private int goldenPalmCount; //Значение поля должно быть больше 0
    private Integer budget; //Значение поля должно быть больше 0, Поле может быть null
    private MpaaRating mpaaRating; //Поле может быть null
    private Person director; //Поле не может быть null

    /**
     * Restrictions:  Value must be more than zero
     *
     * @return Value of field id
     */
    public long getId() {
        return id;
    }

    /**
     * Restrictions: Field should be unique & generating automatically
     *
     * @param id Value of field id
     */
    public void setId(long id) {
        this.id = id;
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
     * Restrictions: Field should be unique & generating automatically
     *
     * @param name Value of field name
     */
    public void setName(String name) {
        this.name = name;
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
    public LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * Restrictions: Field should be unique & generating automatically
     *
     * @param creationDate Value of field creationDate
     */
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Restrictions:  Field should be greater than zero
     *
     * @return Value of field creationDate
     */
    public int getOscarsCount() {
        return oscarsCount;
    }

    /**
     * Restrictions: Field should be greater than zero
     *
     * @param oscarsCount Value of field oscarsCount
     */
    public void setOscarsCount(int oscarsCount) {
        this.oscarsCount = oscarsCount;
    }

    /**
     * Restrictions: Field should be greater than zero
     *
     * @return Value of field goldenPalmCount
     */
    public int getGoldenPalmCount() {
        return goldenPalmCount;
    }

    /**
     * Restrictions: Field should be greater than zero
     *
     * @param goldenPalmCount Value of field goldenPalmCount
     */
    public void setGoldenPalmCount(int goldenPalmCount) {
        this.goldenPalmCount = goldenPalmCount;
    }

    /**
     * Restrictions: Field should be greater than zero & cannot be null
     *
     * @return Value of field budget
     */
    public Integer getBudget() {
        return budget;
    }

    /**
     * Restrictions: Field should be greater than zero
     *
     * @param budget Value of field goldenPalmCount
     */
    public void setBudget(Integer budget) {
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





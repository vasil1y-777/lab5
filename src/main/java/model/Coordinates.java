package model;

/**
 * Model of Coordinates. Sub-model of the <code>Route</code>. Contains getters/setters of each class fields.
 * Some fields have restrictions. It's signed under every method of field.
 */
public class Coordinates {
    private Double x; //Максимальное значение поля: 279, Поле не может быть null
    private Long y; //Значение поля должно быть больше -230, Поле не может быть null

    /**
     * Restrictions: Max value of this field is 279, cannot be null
     * @return Value of field x
     */
    public Double getX() {
        return x;
    }
    /**
     * Restrictions: The value of this field should be greater than -107.
     * @param x Value of field x
     */
    public void setX(Double x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }
}

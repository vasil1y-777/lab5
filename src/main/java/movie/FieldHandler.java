package movie;

import exceptions.BadValueLengthException;
import exceptions.BlankValueException;
import exceptions.NotGreatThanException;
import exceptions.NullValueException;

public class FieldHandler {
    protected Object value;
    protected FieldProperty[] properties;

    FieldHandler(String value, FieldProperty... properties) {
        this.value = value;
        this.properties = properties;
    }

    FieldHandler(Coordinates value, FieldProperty... properties) {
        this.value = value;
        this.properties = properties;
    }

    FieldHandler(int value, FieldProperty... properties) {
        this.value = value;
        this.properties = properties;
    }

    FieldHandler(long value, FieldProperty... properties) {
        this.value = value;
        this.properties = properties;
    }

    FieldHandler(Float value, FieldProperty... properties) {
        this.value = value;
        this.properties = properties;
    }

    FieldHandler(Double value, FieldProperty... properties) {
        this.value = value;
        this.properties = properties;
    }

    FieldHandler(Person value, FieldProperty... properties) {
        this.value = value;
        this.properties = properties;
    }

    public String handleString() throws NullValueException, BlankValueException, BadValueLengthException {
        for (int propertyId = 0; propertyId <= properties.length; propertyId++) {
            FieldProperty property = properties[propertyId];
            if (property == FieldProperty.NOT_NULL && value == null)
                throw new NullValueException();
            if (property == FieldProperty.NOT_BLANK && ((String) value).isBlank())
                throw new BlankValueException();
            if (property == FieldProperty.LENGTH && property.getArgs()[0].equals(((String) value).length()))
                throw new BadValueLengthException((Integer) property.getArgs()[0]);
        }
        return (String) value;
    }

    public Coordinates handleCoordinates() throws NullValueException {
        for (int propertyId = 0; propertyId <= properties.length; propertyId++) {
            FieldProperty property = properties[propertyId];
            if (property == FieldProperty.NOT_NULL && value == null)
                throw new NullValueException();
        }
        return (Coordinates) value;
    }

    public Person handlePerson() throws NullValueException {
        for (int propertyId = 0; propertyId <= properties.length; propertyId++) {
            FieldProperty property = properties[propertyId];
            if (property == FieldProperty.NOT_NULL && value == null)
                throw new NullValueException();
        }
        return (Person) value;
    }

    public long handleLong() throws NullValueException, NotGreatThanException {
        for (int propertyId = 0; propertyId <= properties.length; propertyId++) {
            FieldProperty property = properties[propertyId];
            if (property == FieldProperty.NOT_NULL && value == null)
                throw new NullValueException();
            if (property == FieldProperty.GREAT_THAN_ZERO && (long) value <= 0)
                throw new NotGreatThanException(0);
        }
        return (long) value;
    }

    public int handleInt() throws NullValueException, NotGreatThanException {
        for (int propertyId = 0; propertyId <= properties.length; propertyId++) {
            FieldProperty property = properties[propertyId];
            if (property == FieldProperty.NOT_NULL && value == null)
                throw new NullValueException();
            if (property == FieldProperty.GREAT_THAN_ZERO && (int) value <= (int) FieldProperty.GREAT_THAN_ZERO.getArgs()[0])
                throw new NotGreatThanException(0);
            if (property == FieldProperty.GREAT_THAN_X && (int) value <= (int) FieldProperty.GREAT_THAN_X.getArgs()[0])
                throw new NotGreatThanException((Integer) FieldProperty.GREAT_THAN_X.getArgs()[0]);
        }
        return (int) value;
    }

    public Float handleFloat() throws NullValueException, NotGreatThanException {
        for (int propertyId = 0; propertyId <= properties.length; propertyId++) {
            FieldProperty property = properties[propertyId];
            if (property == FieldProperty.NOT_NULL && value == null)
                throw new NullValueException();
            if (property == FieldProperty.GREAT_THAN_ZERO && (Float) value <= (Float) FieldProperty.GREAT_THAN_ZERO.getArgs()[0])
                throw new NotGreatThanException(0);
            if (property == FieldProperty.GREAT_THAN_X && (int) value <= (int) FieldProperty.GREAT_THAN_X.getArgs()[0])
                throw new NotGreatThanException((Integer) FieldProperty.GREAT_THAN_X.getArgs()[0]);
        }
        return (Float) value;
    }

    public Double handleDouble() throws NullValueException, NotGreatThanException {
        for (int propertyId = 0; propertyId <= properties.length; propertyId++) {
            FieldProperty property = properties[propertyId];
            if (property == FieldProperty.NOT_NULL && value == null)
                throw new NullValueException();
            if (property == FieldProperty.GREAT_THAN_ZERO && (Double) value <= (Double) FieldProperty.GREAT_THAN_ZERO.getArgs()[0])
                throw new NotGreatThanException(0);
            if (property == FieldProperty.GREAT_THAN_X && (int) value <= (int) FieldProperty.GREAT_THAN_X.getArgs()[0])
                throw new NotGreatThanException((Integer) FieldProperty.GREAT_THAN_X.getArgs()[0]);
        }
        return (Double) value;
    }
}


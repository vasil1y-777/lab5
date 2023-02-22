package movie;

import exceptions.BadValueLengthException;
import exceptions.BlankValueException;
import exceptions.NotGreatThanException;
import exceptions.NullValueException;

public class FieldHandler {
    protected Object value;
    protected FieldProperty[] properties;

    FieldHandler(Object value, FieldProperty... properties) {
        this.value = value;
        this.properties = properties;
    }

    public Object handleObject() throws NullValueException {
        for (FieldProperty property : properties) {
            if (property == FieldProperty.NOT_NULL && value == null)
                throw new NullValueException();
        }
        return value;
    }

    public String handleString() throws NullValueException, BlankValueException, BadValueLengthException {
        for (FieldProperty property : properties) {
            if (property == FieldProperty.NOT_NULL && value == null)
                throw new NullValueException();
            if (value != null && property == FieldProperty.NOT_BLANK && ((String) value).isBlank())
                throw new BlankValueException();
            if (value != null && property == FieldProperty.LENGTH && ((int) property.getArgs()[0]) > ((String) value).length())
                throw new BadValueLengthException((Integer) property.getArgs()[0]);
        }
        return (String) value;
    }

    public Long handleLong() throws NullValueException, NotGreatThanException {
        for (FieldProperty property : properties) {
            if (property == FieldProperty.NOT_NULL && value == null)
                throw new NullValueException();
            if (value != null && property == FieldProperty.GREAT_THAN_ZERO && (long) value <= 0)
                throw new NotGreatThanException(0);
        }
        return (Long) value;
    }

    public Integer handleInt() throws NullValueException, NotGreatThanException {
        for (FieldProperty property : properties) {
            if (property == FieldProperty.NOT_NULL && value == null)
                throw new NullValueException();
            if (value != null && property == FieldProperty.GREAT_THAN_ZERO && (int) value <= (int) FieldProperty.GREAT_THAN_ZERO.getArgs()[0])
                throw new NotGreatThanException(0);
            if (value != null && property == FieldProperty.GREAT_THAN_X && (int) value <= (int) FieldProperty.GREAT_THAN_X.getArgs()[0])
                throw new NotGreatThanException((Integer) FieldProperty.GREAT_THAN_X.getArgs()[0]);
        }
        return (Integer) value;
    }

    public Float handleFloat() throws NullValueException, NotGreatThanException {
        for (FieldProperty property : properties) {
            if (property == FieldProperty.NOT_NULL && value == null)
                throw new NullValueException();
            if (value != null && (property == FieldProperty.GREAT_THAN_ZERO && (Float) value <= (Float) FieldProperty.GREAT_THAN_ZERO.getArgs()[0]))
                throw new NotGreatThanException(0);
            if (value != null && property == FieldProperty.GREAT_THAN_X && (int) value <= (int) FieldProperty.GREAT_THAN_X.getArgs()[0])
                throw new NotGreatThanException((Integer) FieldProperty.GREAT_THAN_X.getArgs()[0]);
        }
        return (Float) value;
    }

    public Double handleDouble() throws NullValueException, NotGreatThanException {
        for (FieldProperty property : properties) {
            if (property == FieldProperty.NOT_NULL && value == null)
                throw new NullValueException();
            if (value != null && property == FieldProperty.GREAT_THAN_ZERO && (Double) value <= (Double) FieldProperty.GREAT_THAN_ZERO.getArgs()[0])
                throw new NotGreatThanException(0);
            if (value != null && property == FieldProperty.GREAT_THAN_X && (int) value <= (int) FieldProperty.GREAT_THAN_X.getArgs()[0])
                throw new NotGreatThanException((Integer) FieldProperty.GREAT_THAN_X.getArgs()[0]);
        }
        return (Double) value;
    }
}


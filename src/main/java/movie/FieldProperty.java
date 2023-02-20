package movie;

public enum FieldProperty {
    NOT_NULL,
    GREAT_THAN_ZERO(0),
    GREAT_THAN_X(-230),
    NOT_BLANK,
    UNIQUE,
    LENGTH(7),
    MAX_VALUE(279);

    private final Object[] args;

    FieldProperty(Object... args) {
        this.args = args;
    }

    public Object[] getArgs() {
        return args;
    }
}

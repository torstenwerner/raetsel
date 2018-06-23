package xyz.its_me.raetsel;

public interface Person {
    Tool getTool();

    void setTool(Tool tool);

    Language getLanguage();

    void setLanguage(Language language);

    Sector getSector();

    void setSector(Sector sector);

    Status getStatus();

    void setStatus(Status status);

    Field getField();

    void setField(Field field);

    String name();

    static String nullSafeName(Person person) {
        return person != null ? person.name() : "";
    }

    default long countNonNullRelations() {
        return Utils.countNonNull(getTool(), getLanguage(), getSector(), getStatus(), getField()) - 1;
    }

    default String format() {
        return String.format("%-10s%-10s%-10s%-10s%-10s", nullSafeName(getTool()), nullSafeName(getLanguage()),
                nullSafeName(getSector()), nullSafeName(getStatus()), nullSafeName(getField()));
    }
}

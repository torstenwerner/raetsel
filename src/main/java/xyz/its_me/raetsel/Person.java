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

    default long countNonNullRelations() {
        return Utils.countNonNull(getTool(), getLanguage(), getSector(), getStatus(), getField()) - 1;
    }
}

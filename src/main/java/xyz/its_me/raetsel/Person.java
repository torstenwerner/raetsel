package xyz.its_me.raetsel;

import static xyz.its_me.raetsel.Utils.nullSafeName;

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

    default String format() {
        return String.format("%-10s%-10s%-10s%-10s%-10s", nullSafeName(getTool()), nullSafeName(getLanguage()),
                nullSafeName(getSector()), nullSafeName(getStatus()), nullSafeName(getField()));
    }
}

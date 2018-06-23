package xyz.its_me.raetsel;

import static java.lang.String.format;
import static xyz.its_me.raetsel.Utils.nullSafeName;

public enum Sector implements Person {
    utility,
    telco,
    public_,
    chemistry,
    auto;

    private Tool tool;
    private Language language;
    private Status status;
    private Field field;

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public Sector getSector() {
        return this;
    }

    @Override
    public void setSector(Sector sector) {
        throw new AssertionError("cannot set this");
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public String toString() {
        return format("%-10s%-10s%-10s%-10s%-10s",
                nullSafeName(tool), nullSafeName(language), name(), nullSafeName(status), nullSafeName(field));
    }
}

package xyz.its_me.raetsel;

import static java.lang.String.format;
import static xyz.its_me.raetsel.Utils.nullSafeName;

public enum Language implements Person {
    abap,
    cobol,
    algol,
    java,
    basic;

    private Tool tool;
    private Sector sector;
    private Status status;
    private Field field;

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    @Override
    public Language getLanguage() {
        return this;
    }

    @Override
    public void setLanguage(Language language) {
        throw new AssertionError("cannot set this");
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
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
                nullSafeName(tool), name(), nullSafeName(sector), nullSafeName(status), nullSafeName(field));
    }
}

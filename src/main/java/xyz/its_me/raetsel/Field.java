package xyz.its_me.raetsel;

import static java.lang.String.format;
import static xyz.its_me.raetsel.Utils.nullSafeName;

public enum Field implements Person {
    vw,
    phy,
    bw,
    inf,
    math;

    private Tool tool;
    private Language language;
    private Sector sector;
    private Status status;

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

    @Override
    public Field getField() {
        return this;
    }

    @Override
    public void setField(Field field) {
        throw new AssertionError("cannot set this");
    }

    public long count() {
        return Utils.countNonNull(tool, language, sector, status);
    }

    public String toString() {
        return format("%-10s%-10s%-10s%-10s%-10s",
                nullSafeName(tool), nullSafeName(language), nullSafeName(sector), nullSafeName(status), name());
    }
}

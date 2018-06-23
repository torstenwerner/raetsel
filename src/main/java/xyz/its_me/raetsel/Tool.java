package xyz.its_me.raetsel;

import static java.lang.String.format;
import static xyz.its_me.raetsel.Utils.nullSafeName;

public enum Tool {
    ppt,
    oo,
    kopf,
    aris,
    word;

    private Language language;
    private Sector sector;
    private Status status;
    private Field field;

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

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public long count() {
        return Utils.countNonNull(language, sector, status, field);
    }

    public String toString() {
        return format("%-10s%-10s%-10s%-10s%-10s",
                name(), nullSafeName(language), nullSafeName(sector), nullSafeName(status), nullSafeName(field));
    }
}

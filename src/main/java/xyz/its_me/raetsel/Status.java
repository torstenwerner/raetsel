package xyz.its_me.raetsel;

import static java.lang.String.format;
import static xyz.its_me.raetsel.Utils.nullSafeName;

public enum Status {
    ass,
    junior,
    senior,
    chief,
    partner;

    private Tool tool;
    private Language language;
    private Sector sector;
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

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public long count() {
        return Utils.countNonNull(tool, language, sector, field);
    }

    public String toString() {
        return format("%-10s%-10s%-10s%-10s%-10s",
                nullSafeName(tool), nullSafeName(language), nullSafeName(sector), name(), nullSafeName(field));
    }
}

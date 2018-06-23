package xyz.its_me.raetsel;

abstract public class AbstractPerson implements Person {
    private Tool tool;
    private Language language;
    private Sector sector;
    private Status status;
    private Field field;

    private String name;

    AbstractPerson(String name) {
        this.name = name;
    }

    @Override
    public Tool getTool() {
        return tool;
    }

    @Override
    public void setTool(Tool tool) {
        this.tool = tool;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public Sector getSector() {
        return sector;
    }

    @Override
    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public Field getField() {
        return field;
    }

    @Override
    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public String name() {
        return name;
    }
}

package xyz.its_me.raetsel;

abstract public class AbstractPerson implements Person {
    private Person tool;
    private Person language;
    private Person sector;
    private Person status;
    private Person field;

    private String name;

    AbstractPerson(String name) {
        this.name = name;
    }

    @Override
    public Person getTool() {
        return tool;
    }

    @Override
    public void setTool(Person tool) {
        this.tool = tool;
    }

    @Override
    public Person getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(Person language) {
        this.language = language;
    }

    @Override
    public Person getSector() {
        return sector;
    }

    @Override
    public void setSector(Person sector) {
        this.sector = sector;
    }

    @Override
    public Person getStatus() {
        return status;
    }

    @Override
    public void setStatus(Person status) {
        this.status = status;
    }

    @Override
    public Person getField() {
        return field;
    }

    @Override
    public void setField(Person field) {
        this.field = field;
    }

    @Override
    public String name() {
        return name;
    }
}

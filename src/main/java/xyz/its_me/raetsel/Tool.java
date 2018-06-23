package xyz.its_me.raetsel;

public enum Tool implements Person {
    ppt,
    oo,
    kopf,
    aris,
    word;

    private Language language;
    private Sector sector;
    private Status status;
    private Field field;

    @Override
    public Tool getTool() {
        return this;
    }

    @Override
    public void setTool(Tool tool) {
        throw new AssertionError("cannot set this");
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
}

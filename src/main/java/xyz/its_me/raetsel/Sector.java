package xyz.its_me.raetsel;

import static xyz.its_me.raetsel.Utils.nullSafeMergeRecursive;

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

    @Override
    public void mergeRecursive() {
        this.mergeRelations();
        nullSafeMergeRecursive(status, field);
    }
}

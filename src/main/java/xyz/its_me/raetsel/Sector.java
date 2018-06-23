package xyz.its_me.raetsel;

public enum Sector {
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
}

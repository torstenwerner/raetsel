package xyz.its_me.raetsel;

import java.util.EnumMap;
import java.util.Map;

abstract public class AbstractPerson implements Person {
    private Map<Category, Person> map = new EnumMap<>(Category.class);

    private String name;

    AbstractPerson(String name) {
        this.name = name;
    }

    @Override
    public Person getTool() {
        return map.get(Category.Tool);
    }

    @Override
    public void setTool(Person tool) {
        map.put(Category.Tool, tool);
    }

    @Override
    public Person getLanguage() {
        return map.get(Category.Language);
    }

    @Override
    public void setLanguage(Person language) {
        map.put(Category.Language, language);
    }

    @Override
    public Person getSector() {
        return map.get(Category.Sector);
    }

    @Override
    public void setSector(Person sector) {
        map.put(Category.Sector, sector);
    }

    @Override
    public Person getStatus() {
        return map.get(Category.Status);
    }

    @Override
    public void setStatus(Person status) {
        map.put(Category.Status, status);
    }

    @Override
    public Person getField() {
        return map.get(Category.Field);
    }

    @Override
    public void setField(Person field) {
        map.put(Category.Field, field);
    }

    @Override
    public String name() {
        return name;
    }
}

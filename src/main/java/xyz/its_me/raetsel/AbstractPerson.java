package xyz.its_me.raetsel;

import java.util.EnumMap;
import java.util.Map;

abstract public class AbstractPerson implements Person {
    private Map<Category, Person> map = new EnumMap<>(Category.class);

    private final Category category;
    private final String name;

    AbstractPerson(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    @Override
    public Person get(Category category) {
        if (this.category == category) {
            return this;
        }
        return map.get(category);
    }

    @Override
    public void set(Category category, Person person) {
        if (this.category == category) {
            throw new AssertionError("cannot set this");
        }
        map.put(category, person);
    }
    @Override
    public String name() {
        return name;
    }
}

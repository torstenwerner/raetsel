package xyz.its_me.raetsel;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class DefaultPerson implements Person {
    private Map<Category, Person> map = new EnumMap<>(Category.class);

    private final Category category;
    private final String name;

    DefaultPerson(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public Person get(Category category) {
        if (this.category == category) {
            return this;
        }
        return map.get(category);
    }

    @Override
    public void set(Person person) {
        Objects.requireNonNull(person, "person must not be null for setter");
        if (this.category == person.getCategory()) {
            throw new AssertionError("cannot set this");
        }
        map.put(person.getCategory(), person);
    }

    @Override
    public String name() {
        return name;
    }
}

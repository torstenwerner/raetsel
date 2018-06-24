package xyz.its_me.raetsel;

import java.util.Arrays;
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

    static Person copy(Person person, Map<Person, Person> copyCache) {
        if (copyCache.containsKey(person)) {
            return copyCache.get(person);
        }
        final Person personCopy = new DefaultPerson(person.getCategory(), person.name());
        copyCache.put(person, personCopy);
        Arrays.stream(Category.values())
                .filter(category -> category != person.getCategory())
                .map(person::get)
                .filter(Objects::nonNull)
                .map(otherPerson -> copy(otherPerson, copyCache))
                .forEach(personCopy::set);
        return personCopy;
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

    @Override
    public String toString() {
        return "DefaultPerson{" +
                "map=" + map.keySet() +
                ", category=" + category +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public String shortString() {
        return "DefaultPerson{" +
                "category=" + category +
                ", name='" + name + '\'' +
                '}';
    }
}

package xyz.its_me.raetsel;

import java.util.Objects;
import java.util.stream.Collectors;

public interface Person {
    Category getCategory();

    Person get(Category category);

    void set(Person person);

    String name();

    static String nullSafeName(Person person) {
        return person != null ? person.name() : "";
    }

    default long countNullRelations() {
        return Category.getList().stream()
                .map(this::get)
                .filter(Objects::isNull)
                .count();
    }

    default String format() {
        return Category.getList().stream()
                .map(this::get)
                .map(Person::nullSafeName)
                .map(name -> String.format("%-10s", name))
                .collect(Collectors.joining());
    }

    default int mergeByCategory(Category category, Person otherPerson) {
        final Person thisValue = this.get(category);
        final Person otherValue = otherPerson.get(category);
        if (thisValue == null && otherValue != null) {
            this.set(otherValue);
            return 1;
        }
        if (thisValue != null & otherValue == null) {
            otherPerson.set(thisValue);
            return 1;
        }
        if (thisValue != otherValue) {
            throw new ConflictException(this, thisValue, otherPerson, otherValue);
        }
        return 0;
    }

    default int mergeRelations() {
        return Category.getList().stream()
                .map(this::get)
                .filter(Objects::nonNull)
                .mapToInt(otherPerson ->
                        Category.getList().stream()
                                .mapToInt(category -> mergeByCategory(category, otherPerson))
                                .sum())
                .sum();
    }

    String shortString();
}

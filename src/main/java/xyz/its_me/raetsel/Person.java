package xyz.its_me.raetsel;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.UnaryOperator;
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
        return Arrays.stream(Category.values())
                .map(this::get)
                .filter(Objects::isNull)
                .count();
    }

    default String format() {
        return Arrays.stream(Category.values())
                .map(this::get)
                .map(Person::nullSafeName)
                .map(name -> String.format("%-10s", name))
                .collect(Collectors.joining());
    }

    default int mergeByAccessor(Person otherPerson, UnaryOperator<Person> getter, BiConsumer<Person, Person> setter) {
        final Person thisValue = getter.apply(this);
        final Person otherValue = getter.apply(otherPerson);
        if (thisValue == null && otherValue != null) {
            setter.accept(this, otherValue);
            return 1;
        }
        if (thisValue != null & otherValue == null) {
            setter.accept(otherPerson, thisValue);
            return 1;
        }
        if (thisValue != otherValue) {
            throw new AssertionError("conflict");
        }
        return 0;
    }

    default int merge(Person otherPerson) {
        if (otherPerson == null) {
            return 0;
        }
        return Arrays.stream(Category.values())
                .mapToInt(category -> mergeByAccessor(otherPerson, (person) -> person.get(category), Person::set))
                .sum();
    }

    default int mergeRelations() {
        return Arrays.stream(Category.values())
                .map(this::get)
                .mapToInt(this::merge)
                .sum();
    }
}

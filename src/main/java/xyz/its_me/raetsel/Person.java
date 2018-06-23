package xyz.its_me.raetsel;

import java.util.function.BiConsumer;
import java.util.function.Function;

public interface Person {
    Tool getTool();

    void setTool(Tool tool);

    Language getLanguage();

    void setLanguage(Language language);

    Sector getSector();

    void setSector(Sector sector);

    Status getStatus();

    void setStatus(Status status);

    Field getField();

    void setField(Field field);

    String name();

    static String nullSafeName(Person person) {
        return person != null ? person.name() : "";
    }

    default long countNonNullRelations() {
        return Utils.countNonNull(getTool(), getLanguage(), getSector(), getStatus(), getField()) - 1;
    }

    default String format() {
        return String.format("%-10s%-10s%-10s%-10s%-10s", nullSafeName(getTool()), nullSafeName(getLanguage()),
                nullSafeName(getSector()), nullSafeName(getStatus()), nullSafeName(getField()));
    }

    default <T extends Person> void mergeByAccessor(Person otherPerson, Function<Person, T> getter, BiConsumer<Person, T> setter) {
        final T thisValue = getter.apply(this);
        final T otherValue = getter.apply(otherPerson);
        if (thisValue == null) {
            setter.accept(this, otherValue);
        } else if (otherValue == null) {
            setter.accept(otherPerson, thisValue);
        } else if (thisValue != otherValue) {
            throw new AssertionError("conflict");
        }
    }

    default void merge(Person otherPerson) {
        if (otherPerson != null) {
            mergeByAccessor(otherPerson, Person::getTool, Person::setTool);
            mergeByAccessor(otherPerson, Person::getLanguage, Person::setLanguage);
            mergeByAccessor(otherPerson, Person::getSector, Person::setSector);
            mergeByAccessor(otherPerson, Person::getStatus, Person::setStatus);
            mergeByAccessor(otherPerson, Person::getField, Person::setField);
        }
    }

    default void mergeRelations() {
        merge(getTool());
        merge(getLanguage());
        merge(getSector());
        merge(getStatus());
        merge(getField());
    }

    void mergeRecursive();
}

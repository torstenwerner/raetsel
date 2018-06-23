package xyz.its_me.raetsel;

import java.util.function.BiConsumer;
import java.util.function.UnaryOperator;

public interface Person {
    Person getTool();

    void setTool(Person tool);

    Person getLanguage();

    void setLanguage(Person language);

    Person getSector();

    void setSector(Person sector);

    Person getStatus();

    void setStatus(Person status);

    Person getField();

    void setField(Person field);

    String name();

    static String nullSafeName(Person person) {
        return person != null ? person.name() : "";
    }

    default long countNullRelations() {
        return Utils.countNull(getTool(), getLanguage(), getSector(), getStatus(), getField());
    }

    default String format() {
        return String.format("%-10s%-10s%-10s%-10s%-10s", nullSafeName(getTool()), nullSafeName(getLanguage()),
                nullSafeName(getSector()), nullSafeName(getStatus()), nullSafeName(getField()));
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
        return mergeByAccessor(otherPerson, Person::getTool, Person::setTool) +
                mergeByAccessor(otherPerson, Person::getLanguage, Person::setLanguage) +
                mergeByAccessor(otherPerson, Person::getSector, Person::setSector) +
                mergeByAccessor(otherPerson, Person::getStatus, Person::setStatus) +
                mergeByAccessor(otherPerson, Person::getField, Person::setField);
    }

    default int mergeRelations() {
        return merge(getTool()) +
                merge(getLanguage()) +
                merge(getSector()) +
                merge(getStatus()) +
                merge(getField());
    }
}

package xyz.its_me.raetsel;

public class ConflictException extends RuntimeException {
    private final Person sourcePerson;
    private final Person sourceValue;
    private final Person targetPerson;
    private final Person targetValue;

    public ConflictException(Person sourcePerson, Person sourceValue, Person targetPerson, Person targetValue) {
        this.sourcePerson = sourcePerson;
        this.sourceValue = sourceValue;
        this.targetPerson = targetPerson;
        this.targetValue = targetValue;
    }

    @Override
    public String toString() {
        return "ConflictException{" +
                "sourcePerson=" + sourcePerson.shortString() +
                ", sourceValue=" + sourceValue.shortString() +
                ", targetPerson=" + targetPerson.shortString() +
                ", targetValue=" + targetValue.shortString() +
                '}';
    }
}

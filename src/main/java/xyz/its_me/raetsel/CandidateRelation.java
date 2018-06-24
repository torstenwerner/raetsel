package xyz.its_me.raetsel;

import lombok.Value;

@Value
public class CandidateRelation {
    Person sourcePerson;
    Category targetCategory;
    Person targetPerson;

    @Override
    public String toString() {
        return "CandidateRelation{" +
                "sourcePerson=" + sourcePerson.name() +
                ", targetCategory=" + targetCategory +
                ", targetPerson=" + targetPerson.name() +
                '}';
    }
}

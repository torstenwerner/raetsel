package xyz.its_me.raetsel;

import lombok.Value;

@Value
public class CandidateRelation {
    Person sourcePerson;
    Person targetPerson;

    @Override
    public String toString() {
        return "CandidateRelation{" +
                "sourceCategory=" + sourcePerson.getCategory() +
                ", sourcePerson=" + sourcePerson.name() +
                ", targetCategory=" + targetPerson.getCategory() +
                ", targetPerson=" + targetPerson.name() +
                '}';
    }
}

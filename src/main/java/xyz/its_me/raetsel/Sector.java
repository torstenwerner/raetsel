package xyz.its_me.raetsel;

import java.util.Arrays;
import java.util.List;

public class Sector extends AbstractPerson {
    private Sector(String name) {
        super(name);
    }

    final static Sector utility = new Sector("utility");
    final static Sector telco = new Sector("telco");
    final static Sector public_ = new Sector("public");
    final static Sector chemistry = new Sector("chemistry");
    final static Sector auto = new Sector("auto");

    static List<Person> values() {
        return Arrays.asList(utility, telco, public_, chemistry, auto);
    }

    @Override
    public Sector getSector() {
        return this;
    }

    @Override
    public void setSector(Person sector) {
        throw new AssertionError("cannot set this");
    }
}

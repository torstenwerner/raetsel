package xyz.its_me.raetsel;

import java.util.Arrays;
import java.util.List;

public class Sector extends AbstractPerson {
    private Sector(String name) {
        super(Category.Sector, name);
    }

    final static Person utility = new AbstractPerson(Category.Sector, "utility");
    final static Person telco = new AbstractPerson(Category.Sector, "telco");
    final static Person public_ = new AbstractPerson(Category.Sector, "public");
    final static Person chemistry = new AbstractPerson(Category.Sector, "chemistry");
    final static Person auto = new AbstractPerson(Category.Sector, "auto");

    static List<Person> values() {
        return Arrays.asList(utility, telco, public_, chemistry, auto);
    }
}

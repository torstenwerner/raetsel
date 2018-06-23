package xyz.its_me.raetsel;

import java.util.Arrays;
import java.util.List;

public class Field extends AbstractPerson {
    private Field(String name) {
        super(Category.Field, name);
    }

    final static Person vw = new AbstractPerson(Category.Field, "vw");
    final static Person phy = new AbstractPerson(Category.Field, "phy");
    final static Person bw = new AbstractPerson(Category.Field, "bw");
    final static Person inf = new AbstractPerson(Category.Field, "inf");
    final static Person math = new AbstractPerson(Category.Field, "math");

    static List<Person> values() {
        return Arrays.asList(vw, phy, bw, inf, math);
    }
}

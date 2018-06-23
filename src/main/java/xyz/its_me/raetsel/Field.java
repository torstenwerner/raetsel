package xyz.its_me.raetsel;

import java.util.Arrays;
import java.util.List;

public class Field extends AbstractPerson {
    private Field(String name) {
        super(name);
    }

    final static Field vw = new Field("vw");
    final static Field phy = new Field("phy");
    final static Field bw = new Field("bw");
    final static Field inf = new Field("inf");
    final static Field math = new Field("math");

    static List<Person> values() {
        return Arrays.asList(vw, phy, bw, inf, math);
    }

    @Override
    public Field getField() {
        return this;
    }

    @Override
    public void setField(Person field) {
        throw new AssertionError("cannot set this");
    }
}

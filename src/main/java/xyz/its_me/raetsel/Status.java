package xyz.its_me.raetsel;

import java.util.Arrays;
import java.util.List;

public class Status extends AbstractPerson {
    private Status(String name) {
        super(Category.Status, name);
    }

    final static Person ass = new AbstractPerson(Category.Status, "ass");
    final static Person junior = new AbstractPerson(Category.Status, "junior");
    final static Person senior = new AbstractPerson(Category.Status, "senior");
    final static Person chief = new AbstractPerson(Category.Status, "chief");
    final static Person partner = new AbstractPerson(Category.Status, "partner");

    static List<Person> values() {
        return Arrays.asList(ass, junior, senior, chief, partner);
    }
}

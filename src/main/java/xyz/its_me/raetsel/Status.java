package xyz.its_me.raetsel;

import java.util.Arrays;
import java.util.List;

public class Status extends AbstractPerson {
    private Status(String name) {
        super(Category.Status, name);
    }

    final static Status ass = new Status("ass");
    final static Status junior = new Status("junior");
    final static Status senior = new Status("senior");
    final static Status chief = new Status("chief");
    final static Status partner = new Status("partner");

    static List<Person> values() {
        return Arrays.asList(ass, junior, senior, chief, partner);
    }
}

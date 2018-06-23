package xyz.its_me.raetsel;

import java.util.Arrays;
import java.util.List;

public class Language extends AbstractPerson {
    private Language(String name) {
        super(Category.Language, name);
    }

    final static Person abap = new AbstractPerson(Category.Language, "abap");
    final static Person cobol = new AbstractPerson(Category.Language, "cobol");
    final static Person algol = new AbstractPerson(Category.Language, "algol");
    final static Person java = new AbstractPerson(Category.Language, "java");
    final static Person basic = new AbstractPerson(Category.Language, "basic");

    static List<Person> values() {
        return Arrays.asList(abap, cobol, algol, java, basic);
    }
}

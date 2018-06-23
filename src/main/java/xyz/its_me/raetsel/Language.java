package xyz.its_me.raetsel;

import java.util.Arrays;
import java.util.List;

public class Language extends AbstractPerson {
    private Language(String name) {
        super(Category.Language, name);
    }

    final static Language abap = new Language("abap");
    final static Language cobol = new Language("cobol");
    final static Language algol = new Language("algol");
    final static Language java = new Language("java");
    final static Language basic = new Language("basic");

    static List<Person> values() {
        return Arrays.asList(abap, cobol, algol, java, basic);
    }
}

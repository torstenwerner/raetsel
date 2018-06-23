package xyz.its_me.raetsel;

import java.util.Arrays;
import java.util.List;

public class Tool extends AbstractPerson {
    private Tool(String name) {
        super(Category.Tool, name);
    }

    static final Person ppt = new AbstractPerson(Category.Tool, "ppt");
    static final Person oo = new AbstractPerson(Category.Tool, "oo");
    static final Person kopf = new AbstractPerson(Category.Tool, "kopf");
    static final Person aris = new AbstractPerson(Category.Tool, "aris");
    static final Person word = new AbstractPerson(Category.Tool, "word");

    static List<Person> values() {
        return Arrays.asList(ppt, oo, kopf, aris, word);
    }
}

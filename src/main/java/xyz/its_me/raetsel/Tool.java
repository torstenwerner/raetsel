package xyz.its_me.raetsel;

import java.util.Arrays;
import java.util.List;

public class Tool extends AbstractPerson {
    private Tool(String name) {
        super(name);
    }

    static final Tool ppt = new Tool("ppt");
    static final Tool oo = new Tool("oo");
    static final Tool kopf = new Tool("kopf");
    static final Tool aris = new Tool("aris");
    static final Tool word = new Tool("word");

    static List<Person> values() {
        return Arrays.asList(ppt, oo, kopf, aris, word);
    }

    @Override
    public Tool getTool() {
        return this;
    }

    @Override
    public void setTool(Person tool) {
        throw new AssertionError("cannot set this");
    }
}

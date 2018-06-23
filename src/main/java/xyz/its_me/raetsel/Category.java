package xyz.its_me.raetsel;

import java.util.ArrayList;
import java.util.List;

public enum Category {
    Tool,
    Language,
    Sector,
    Status,
    Field;

    private final List<Person> personList = new ArrayList<>();

    private Person newPerson(String name) {
        final DefaultPerson person = new DefaultPerson(this, name);
        personList.add(person);
        return person;
    }

    List<Person> persons() {
        return personList;
    }

    static final Person ppt = Tool.newPerson("ppt");
    static final Person oo = Tool.newPerson("oo");
    static final Person kopf = Tool.newPerson("kopf");
    static final Person aris = Tool.newPerson("aris");
    static final Person word = Tool.newPerson("word");

    final static Person abap = Language.newPerson("abap");
    final static Person cobol = Language.newPerson("cobol");
    final static Person algol = Language.newPerson("algol");
    final static Person java = Language.newPerson("java");
    final static Person basic = Language.newPerson("basic");

    final static Person utility = Sector.newPerson("utility");
    final static Person telco = Sector.newPerson("telco");
    final static Person public_ = Sector.newPerson("public");
    final static Person chemistry = Sector.newPerson("chemistry");
    final static Person auto = Sector.newPerson("auto");

    final static Person ass = Status.newPerson("ass");
    final static Person junior = Status.newPerson("junior");
    final static Person senior = Status.newPerson("senior");
    final static Person chief = Status.newPerson("chief");
    final static Person partner = Status.newPerson("partner");

    final static Person vw = Field.newPerson("vw");
    final static Person phy = Field.newPerson("phy");
    final static Person bw = Field.newPerson("bw");
    final static Person inf = Field.newPerson("inf");
    final static Person math = Field.newPerson("math");
}

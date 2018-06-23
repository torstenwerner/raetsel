package xyz.its_me.raetsel;

import java.util.Arrays;
import java.util.List;

public enum Category {
    Tool {
        @Override
        List<Person> persons() {
            return Arrays.asList(ppt, oo, kopf, aris, word);
        }
    },
    Language {
        @Override
        List<Person> persons() {
            return Arrays.asList(abap, cobol, algol, java, basic);
        }
    },
    Sector {
        @Override
        List<Person> persons() {
            return Arrays.asList(utility, telco, public_, chemistry, auto);
        }
    },
    Status {
        @Override
        List<Person> persons() {
            return Arrays.asList(ass, junior, senior, chief, partner);
        }
    },
    Field {
        @Override
        List<Person> persons() {
            return Arrays.asList(vw, phy, bw, inf, math);
        }
    };

    abstract List<Person> persons();

    static final Person ppt = new AbstractPerson(Category.Tool, "ppt");
    static final Person oo = new AbstractPerson(Category.Tool, "oo");
    static final Person kopf = new AbstractPerson(Category.Tool, "kopf");
    static final Person aris = new AbstractPerson(Category.Tool, "aris");
    static final Person word = new AbstractPerson(Category.Tool, "word");

    final static Person abap = new AbstractPerson(Category.Language, "abap");
    final static Person cobol = new AbstractPerson(Category.Language, "cobol");
    final static Person algol = new AbstractPerson(Category.Language, "algol");
    final static Person java = new AbstractPerson(Category.Language, "java");
    final static Person basic = new AbstractPerson(Category.Language, "basic");

    final static Person utility = new AbstractPerson(Category.Sector, "utility");
    final static Person telco = new AbstractPerson(Category.Sector, "telco");
    final static Person public_ = new AbstractPerson(Category.Sector, "public");
    final static Person chemistry = new AbstractPerson(Category.Sector, "chemistry");
    final static Person auto = new AbstractPerson(Category.Sector, "auto");

    final static Person ass = new AbstractPerson(Category.Status, "ass");
    final static Person junior = new AbstractPerson(Category.Status, "junior");
    final static Person senior = new AbstractPerson(Category.Status, "senior");
    final static Person chief = new AbstractPerson(Category.Status, "chief");
    final static Person partner = new AbstractPerson(Category.Status, "partner");

    final static Person vw = new AbstractPerson(Category.Field, "vw");
    final static Person phy = new AbstractPerson(Category.Field, "phy");
    final static Person bw = new AbstractPerson(Category.Field, "bw");
    final static Person inf = new AbstractPerson(Category.Field, "inf");
    final static Person math = new AbstractPerson(Category.Field, "math");
}

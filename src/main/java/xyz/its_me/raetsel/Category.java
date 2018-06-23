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

    static final Person ppt = new DefaultPerson(Category.Tool, "ppt");
    static final Person oo = new DefaultPerson(Category.Tool, "oo");
    static final Person kopf = new DefaultPerson(Category.Tool, "kopf");
    static final Person aris = new DefaultPerson(Category.Tool, "aris");
    static final Person word = new DefaultPerson(Category.Tool, "word");

    final static Person abap = new DefaultPerson(Category.Language, "abap");
    final static Person cobol = new DefaultPerson(Category.Language, "cobol");
    final static Person algol = new DefaultPerson(Category.Language, "algol");
    final static Person java = new DefaultPerson(Category.Language, "java");
    final static Person basic = new DefaultPerson(Category.Language, "basic");

    final static Person utility = new DefaultPerson(Category.Sector, "utility");
    final static Person telco = new DefaultPerson(Category.Sector, "telco");
    final static Person public_ = new DefaultPerson(Category.Sector, "public");
    final static Person chemistry = new DefaultPerson(Category.Sector, "chemistry");
    final static Person auto = new DefaultPerson(Category.Sector, "auto");

    final static Person ass = new DefaultPerson(Category.Status, "ass");
    final static Person junior = new DefaultPerson(Category.Status, "junior");
    final static Person senior = new DefaultPerson(Category.Status, "senior");
    final static Person chief = new DefaultPerson(Category.Status, "chief");
    final static Person partner = new DefaultPerson(Category.Status, "partner");

    final static Person vw = new DefaultPerson(Category.Field, "vw");
    final static Person phy = new DefaultPerson(Category.Field, "phy");
    final static Person bw = new DefaultPerson(Category.Field, "bw");
    final static Person inf = new DefaultPerson(Category.Field, "inf");
    final static Person math = new DefaultPerson(Category.Field, "math");
}

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

    private Person newPerson(String name) {
        return new DefaultPerson(this, name);
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

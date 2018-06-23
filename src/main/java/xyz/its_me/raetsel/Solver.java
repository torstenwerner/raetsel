package xyz.its_me.raetsel;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static xyz.its_me.raetsel.Field.math;
import static xyz.its_me.raetsel.Field.vw;
import static xyz.its_me.raetsel.Language.*;
import static xyz.its_me.raetsel.Sector.*;
import static xyz.its_me.raetsel.Status.*;
import static xyz.its_me.raetsel.Tool.*;
import static xyz.its_me.raetsel.Utils.mergeRelations;

@Component
public class Solver implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        configure();
        do {
            Utils.printRelations();
        } while (merge() > 0);
    }

    private void configure() {
        ppt.setLanguage(abap);
        word.setLanguage(basic);
        oo.setSector(telco);
        java.setSector(chemistry);
        auto.setStatus(ass);
        aris.setStatus(partner);
        kopf.setStatus(junior);
        word.setField(math);
        abap.setField(vw);
        utility.setField(vw);
    }

    private int merge() {
        return mergeRelations(Tool.values(), Language.values(), Sector.values(), Status.values(), Field.values());
    }
}

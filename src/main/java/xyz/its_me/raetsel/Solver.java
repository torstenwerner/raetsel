package xyz.its_me.raetsel;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

import static xyz.its_me.raetsel.Category.*;

@Component
public class Solver implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        configure();
        final DataContainer firstContainer = new DataContainer();
        final List<CandidateRelation> candidates = firstContainer.candidates();
        System.out.println(candidates);
        final DataContainer nextContainer = firstContainer.tryCandidate(candidates.get(0));
    }

    private void configure() {
        ppt.set(abap);
        word.set(basic);
        oo.set(telco);
        java.set(chemistry);
        auto.set(ass);
        aris.set(partner);
        kopf.set(junior);
        word.set(math);
        abap.set(vw);
        utility.set(vw);
    }
}

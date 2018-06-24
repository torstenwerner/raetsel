package xyz.its_me.raetsel;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import static xyz.its_me.raetsel.Category.*;

@Component
public class Solver implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        configure();
        final DataContainer firstContainer = new DataContainer();
        final Instant start = Instant.now();
        final List<DataContainer> results = firstContainer.iterate();
        final Instant stop = Instant.now();
        //results.forEach(DataContainer::printFirstRelations);
        System.out.printf("solution count: %d%n", results.size());
        System.out.printf("time: %d ms%n", Duration.between(start, stop).toMillis());

        DataContainer.shutdown();
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

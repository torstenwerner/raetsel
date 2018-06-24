package xyz.its_me.raetsel;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;
import static xyz.its_me.raetsel.Category.*;

@Component
public class Solver implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        configure();
        final DataContainer firstContainer = new DataContainer();
        final DataContainer nextContainer = firstContainer.deepCopy();
        int changes;
        do {
            nextContainer.printRelations();
            changes = nextContainer.merge();
            System.out.printf("changes: %d%n", changes);
        } while (changes > 0);

        nextContainer.candidates()
                .ifPresent(tuple -> {
                    System.out.printf("first missing pair: %s -> %s%n", tuple.getFirst().name(), tuple.getSecond());
                    System.out.printf("candidates: %s%n", tuple.getThird().stream().map(Person::name).collect(toList()));
                });
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

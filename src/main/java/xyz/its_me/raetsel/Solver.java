package xyz.its_me.raetsel;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static xyz.its_me.raetsel.Category.*;
import static xyz.its_me.raetsel.Utils.deepCopy;

@Component
public class Solver implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        configure();
        final Map<Category, List<Person>> startMap = Category.toMap();
        final Map<Category, List<Person>> nextMap = deepCopy(startMap);
        int changes;
        do {
            Utils.printRelations(nextMap);
            changes = merge(nextMap);
            System.out.printf("changes: %d%n", changes);
        } while (changes > 0);
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

    private int merge(Map<Category, List<Person>> personMap) {
        return personMap.values().stream()
                .flatMap(List::stream)
                .mapToInt(Person::mergeRelations)
                .sum();
    }
}

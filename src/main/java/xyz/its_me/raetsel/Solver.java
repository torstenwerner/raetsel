package xyz.its_me.raetsel;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static xyz.its_me.raetsel.Category.*;

@Component
public class Solver implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        configure();
        do {
            Utils.printRelations();
        } while (merge() > 0);

        final Map<Category, List<Person>> startMap = Category.toMap();
        System.out.println(startMap);
        final Map<Category, List<Person>> nextMap = deepCopy(startMap);
        System.out.println(nextMap);
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

    private int merge() {
        return Arrays.stream(Category.values())
                .map(Category::persons)
                .flatMap(List::stream)
                .mapToInt(Person::mergeRelations)
                .sum();
    }
}

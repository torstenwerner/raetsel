package xyz.its_me.raetsel;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.IntStream;

import static xyz.its_me.raetsel.Category.*;

class Solver {

    private static final int REPETITIONS = 25;

    void run() {
        configure();
        final DataContainer firstContainer = new DataContainer();

        IntStream.range(0, REPETITIONS).forEach(i -> solve(firstContainer));
    }

    private void solve(DataContainer firstContainer) {
        final Instant start = Instant.now();
        final List<DataContainer> results = firstContainer.iterate();
        final Instant stop = Instant.now();
        //results.forEach(DataContainer::printFirstRelations);
        System.out.printf("solution count: %d%n", results.size());
        System.out.printf("time: %d ms%n", Duration.between(start, stop).toMillis());
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
        phy.set(germany);
    }
}

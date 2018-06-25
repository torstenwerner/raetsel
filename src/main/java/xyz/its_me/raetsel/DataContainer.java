package xyz.its_me.raetsel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

class DataContainer {
    private final List<Category> data;

    private DataContainer(List<Category> data) {
        this.data = data;
    }

    DataContainer() {
        this(Category.getList());
        mergeRecursively();
    }

    private void printRelations() {
        data.stream().map(Category::getPeople).forEach(this::printRelations);
        System.out.printf("missing relation count: %d%n%n", countNullRelations());
    }

    void printFirstRelations() {
        printRelations(data.get(0).getPeople());
    }

    private void printRelations(List<Person> personList) {
        personList.stream().map(Person::format).forEach(System.out::println);
        System.out.println();
    }

    private long countNullRelations() {
        return data.stream()
                .map(Category::getPeople)
                .flatMap(List::stream)
                .mapToLong(Person::countNullRelations)
                .sum();
    }

    private void mergeRecursively() {
        int changes;
        do {
            //printRelations();
            changes = merge();
            //System.out.printf("changes: %d%n", changes);
        } while (changes > 0);

    }

    private int merge() {
        return data.stream()
                .map(Category::getPeople)
                .flatMap(List::stream)
                .mapToInt(Person::mergeRelations)
                .sum();
    }

    private List<CandidateRelation> candidates() {
        return Category.getList().stream()
                .flatMap(leftCategory ->
                        Category.getList().stream()
                                .filter(rightCategory -> leftCategory != rightCategory)
                                .map(rightCategory -> new Pair<>(leftCategory, rightCategory)))
                .flatMap(pair ->
                        data.get(pair.getFirst().getOrdinal()).getPeople().stream()
                                .map(person -> new Tuple<>(pair.getFirst(), pair.getSecond(), person)))
                .filter(tuple -> tuple.getThird().get(tuple.getSecond()) == null)
                .findFirst()
                .map(tuple ->
                        candidates(tuple.getThird(), tuple.getSecond()).stream()
                                .map(person -> new CandidateRelation(tuple.getThird(), person)))
                .orElse(Stream.empty())
                .collect(toList());
    }

    private List<Person> candidates(Person person, Category category) {
        final Category firstCategory = person.getCategory();
        return data.get(category.getOrdinal()).getPeople().stream()
                .filter(otherPerson -> otherPerson.get(firstCategory) == null)
                .collect(toList());
    }

    private DataContainer tryCandidate(CandidateRelation candidateRelation) {
        //System.out.printf("trying candidate: %s%n", candidateRelation);

        final Map<Person, Person> copyCache = new HashMap<>(dataSize());
        final DataContainer nextContainer = deepCopy(copyCache);
        final Person sourcePerson = copyCache.get(candidateRelation.getSourcePerson());
        final Person targetPerson = copyCache.get(candidateRelation.getTargetPerson());
        sourcePerson.set(targetPerson);
        try {
            nextContainer.mergeRecursively();
        } catch (ConflictException e) {
            //System.out.printf("conflict: %s%n", e);
            return null;
        }
        return nextContainer;
    }

    private int dataSize() {
        return data.size() * data.get(0).getPeople().size();
    }

    private DataContainer deepCopy(Map<Person, Person> copyCache) {
        final List<Category> targetMap = data.stream()
                .map((category) -> deepCopy(category, copyCache))
                .collect(toList());
        return new DataContainer(targetMap);
    }

    private Category deepCopy(Category category, Map<Person, Person> copyCache) {
        final Category categoryCopy = new Category(category);
        categoryCopy.getPeople().addAll(category.getPeople().stream()
                .map(person -> DefaultPerson.copy(person, copyCache))
                .collect(toList()));
        return categoryCopy;
    }

    List<DataContainer> iterate() {
        final List<CandidateRelation> candidateRelations = candidates();
        if (candidateRelations.isEmpty()) {
            return singletonList(this);
        }
        return candidateRelations.stream()
                .parallel()
                .map(this::tryCandidate)
                .filter(Objects::nonNull)
                .map(DataContainer::iterate)
                .flatMap(List::stream)
                .collect(toList());
    }
}

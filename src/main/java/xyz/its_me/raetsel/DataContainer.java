package xyz.its_me.raetsel;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class DataContainer {
    private final Map<Category, List<Person>> data;

    private DataContainer(Map<Category, List<Person>> data) {
        this.data = data;
    }

    DataContainer() {
        this(Category.toMap());
    }

    DataContainer deepCopy() {
        final Map<Person, Person> copyCache = new HashMap<>(data.size() * Category.values().length);
        final Map<Category, List<Person>> targetMap = new EnumMap<>(Category.class);
        data.forEach((key, value) -> targetMap.put(key, deepCopy(value, copyCache)));
        return new DataContainer(targetMap);
    }

    private List<Person> deepCopy(List<Person> personList, Map<Person, Person> copyCache) {
        return personList.stream()
                .map(person -> DefaultPerson.copy(person, copyCache))
                .collect(toList());
    }

    void printRelations() {
        data.values().forEach(this::printRelations);
        System.out.printf("missing relation count: %d%n%n", countNullRelations());
    }

    private void printRelations(List<Person> personList) {
        personList.stream().map(Person::format).forEach(System.out::println);
        System.out.println();
    }

    private long countNullRelations() {
        return data.values().stream()
                .flatMap(List::stream)
                .mapToLong(Person::countNullRelations)
                .sum();
    }

    int merge() {
        return data.values().stream()
                .flatMap(List::stream)
                .mapToInt(Person::mergeRelations)
                .sum();
    }

    List<CandidateRelation> candidates() {
        return Arrays.stream(Category.values())
                .flatMap(leftCategory ->
                        Arrays.stream(Category.values())
                                .filter(rightCategory -> leftCategory != rightCategory)
                                .map(rightCategory -> new Pair<>(leftCategory, rightCategory)))
                .flatMap(pair ->
                        data.get(pair.getFirst()).stream()
                                .map(person -> new Tuple<>(pair.getFirst(), pair.getSecond(), person)))
                .filter(tuple -> tuple.getThird().get(tuple.getSecond()) == null)
                .findFirst()
                .map(tuple ->
                        candidates(tuple.getThird(), tuple.getSecond()).stream()
                                .map(person -> new CandidateRelation(tuple.getThird(), tuple.getSecond(), person)))
                .orElse(Stream.empty())
                .collect(toList());
    }

    private List<Person> candidates(Person person, Category category) {
        final Category firstCategory = person.getCategory();
        return data.get(category).stream()
                .filter(otherPerson -> otherPerson.get(firstCategory) == null)
                .collect(toList());
    }
}

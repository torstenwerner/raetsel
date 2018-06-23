package xyz.its_me.raetsel;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Utils {
    static long countNonNull(Object... objects) {
        return Arrays.stream(objects)
                .filter(Objects::nonNull)
                .count();
    }

    private static long countForArray(List<Person> personList) {
        return personList.stream().mapToLong(Person::countNonNullRelations).sum();
    }

    private static long countRelations() {
        return countForArray(Tool.values()) +
                countForArray(Language.values()) +
                countForArray(Sector.values()) +
                countForArray(Status.values()) +
                countForArray(Field.values());
    }

    private static void printRelations(List<Person> personList) {
        personList.stream().map(Person::format).forEach(System.out::println);
        System.out.println();
    }

    static void printRelations() {
        printRelations(Tool.values());
        printRelations(Language.values());
        printRelations(Sector.values());
        printRelations(Status.values());
        printRelations(Field.values());

        System.out.printf("relation count: %d%n%n", Utils.countRelations());
    }

    @SafeVarargs
    static int mergeRelations(List<Person>... lists) {
        return Arrays.stream(lists)
                .flatMap(List::stream)
                .mapToInt(Person::mergeRelations)
                .sum();
    }
}

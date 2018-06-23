package xyz.its_me.raetsel;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Utils {
    static long countNull(Object... objects) {
        return Arrays.stream(objects)
                .filter(Objects::isNull)
                .count();
    }

    private static long countNullForList(List<Person> personList) {
        return personList.stream().mapToLong(Person::countNullRelations).sum();
    }

    private static long countNullRelations() {
        return countNullForList(Tool.values()) +
                countNullForList(Language.values()) +
                countNullForList(Sector.values()) +
                countNullForList(Status.values()) +
                countNullForList(Field.values());
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

        System.out.printf("missing relation count: %d%n%n", Utils.countNullRelations());
    }

    @SafeVarargs
    static int mergeRelations(List<Person>... lists) {
        return Arrays.stream(lists)
                .flatMap(List::stream)
                .mapToInt(Person::mergeRelations)
                .sum();
    }
}

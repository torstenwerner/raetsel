package xyz.its_me.raetsel;

import java.util.Arrays;
import java.util.Objects;

public class Utils {
    public static long countNonNull(Object... objects) {
        return Arrays.stream(objects)
                .filter(Objects::nonNull)
                .count();
    }

    public static long countForArray(Person[] array) {
        return Arrays.stream(array).mapToLong(Person::countNonNullRelations).sum();
    }

    public static long countRelations() {
        return countForArray(Tool.values()) +
                countForArray(Language.values()) +
                countForArray(Sector.values()) +
                countForArray(Status.values()) +
                countForArray(Field.values());
    }

    private static void printRelations(Person[] array) {
        Arrays.stream(array).map(Person::format).forEach(System.out::println);
        System.out.println();
    }

    public static void printRelations() {
        printRelations(Tool.values());
        printRelations(Language.values());
        printRelations(Sector.values());
        printRelations(Status.values());
        printRelations(Field.values());

        System.out.printf("relation count: %d%n%n", Utils.countRelations());
    }

    static void nullSafeMergeRecursive(Person... persons) {
        Arrays.stream(persons).filter(Objects::nonNull).forEach(Person::mergeRecursive);
    }
}

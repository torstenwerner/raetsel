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

    public static String nullSafeName(Enum<?> enumObject) {
        return enumObject != null ? enumObject.name() : "";
    }

    private static <T> void printRelations(T[] array) {
        Arrays.stream(array).forEach(System.out::println);
        System.out.println();
    }

    public static void printRelations() {
        printRelations(Tool.values());
        printRelations(Language.values());
        printRelations(Sector.values());
        printRelations(Status.values());
        printRelations(Field.values());
    }
}

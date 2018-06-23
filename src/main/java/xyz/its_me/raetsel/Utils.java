package xyz.its_me.raetsel;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.ToLongFunction;

public class Utils {
    public static long countNonNull(Object... objects) {
        return Arrays.stream(objects)
                .filter(Objects::nonNull)
                .count();
    }

    public static <T> long countForArray(T[] array, ToLongFunction<T> countSupplier) {
        return Arrays.stream(array).mapToLong(countSupplier).sum();
    }

    public static long countRelations() {
        return countForArray(Tool.values(), Tool::count) +
                countForArray(Language.values(), Language::count) +
                countForArray(Sector.values(), Sector::count) +
                countForArray(Status.values(), Status::count) +
                countForArray(Field.values(), Field::count);
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

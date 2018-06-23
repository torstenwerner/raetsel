package xyz.its_me.raetsel;

import java.util.Arrays;
import java.util.List;

class Utils {
    private static long countNullForList(List<Person> personList) {
        return personList.stream().mapToLong(Person::countNullRelations).sum();
    }

    private static long countNullRelations() {
        return Arrays.stream(Category.values())
                .map(Category::persons)
                .mapToLong(Utils::countNullForList)
                .sum();
    }

    private static void printRelations(List<Person> personList) {
        personList.stream().map(Person::format).forEach(System.out::println);
        System.out.println();
    }

    static void printRelations() {
        Arrays.stream(Category.values())
                .map(Category::persons)
                .forEach(Utils::printRelations);

        System.out.printf("missing relation count: %d%n%n", Utils.countNullRelations());
    }
}

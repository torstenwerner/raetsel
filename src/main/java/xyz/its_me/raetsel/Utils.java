package xyz.its_me.raetsel;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

class Utils {

    static void printRelations(Map<Category, List<Person>> personMap) {
        personMap.values().forEach(Utils::printRelations);
        System.out.printf("missing relation count: %d%n%n", Utils.countNullRelations(personMap));
    }

    private static void printRelations(List<Person> personList) {
        personList.stream().map(Person::format).forEach(System.out::println);
        System.out.println();
    }

    private static long countNullRelations(Map<Category, List<Person>> personMap) {
        return personMap.values().stream()
                .flatMap(List::stream)
                .mapToLong(Person::countNullRelations)
                .sum();
    }

    static Map<Category, List<Person>> deepCopy(Map<Category, List<Person>> sourceMap) {
        final Map<Person, Person> copyCache = new HashMap<>(sourceMap.size() * Category.values().length);
        final Map<Category, List<Person>> targetMap = new EnumMap<>(Category.class);
        sourceMap.forEach((key, value) -> targetMap.put(key, deepCopy(value, copyCache)));
        return targetMap;
    }

    private static List<Person> deepCopy(List<Person> personList, Map<Person, Person> copyCache) {
        return personList.stream()
                .map(person -> DefaultPerson.copy(person, copyCache))
                .collect(toList());
    }
}

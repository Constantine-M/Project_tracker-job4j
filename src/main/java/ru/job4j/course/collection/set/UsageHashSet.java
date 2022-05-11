package ru.job4j.course.collection.set;

import java.util.HashSet;

/**
 * Этот механизм удобно использовать, если нам нужно получить только уникальные элементы.
 * Коллекции java.util.Set не будут добавлять дублирующие элементы.
 */
public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> names = new HashSet<>();
        names.add("Petr");
        names.add("Ivan");
        names.add("Ivan");
        names.add("Vasily");
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("А теперь по задачке...");
        HashSet<String> autos = new HashSet<>();
        autos.add("Lada");
        autos.add("BMW");
        autos.add("Volvo");
        autos.add("Toyota");
        for (String auto : autos) {
            System.out.println(auto);
        }
    }
}

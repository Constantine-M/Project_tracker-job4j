package ru.job4j.course.collection;

import java.util.ArrayList;

/**
 * Данный класс показывает на примере, что из себя представляют
 * коллекции и как с ними можно работать.
 * При добавлении записи в коллекцию не обязательно указывать индекс.
 * Индекс в коллекциях применяется/используется реже, чем в массивах.
 * Далее мы познакомимся с Мар (тоже коллекция). В некоторых случаях она больше подходит.
 */
public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Petr");
        names.add("Ivan");
        names.add("Stepan");
        for (String list : names) {
            System.out.println(list);
        }
    }
}

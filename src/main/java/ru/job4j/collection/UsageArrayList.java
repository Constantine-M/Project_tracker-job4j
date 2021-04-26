package ru.job4j.collection;

import java.util.ArrayList;

/**
 * Данный класс показывает на примере, что из себя представляют коллекции и как с ними можно работать.
 */
public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add(0, "Petr");
        names.add(1, "Ivan");
        names.add(2, "Stepan");
        for (String list : names) {
            System.out.println(list);
        }
    }
}

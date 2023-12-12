package ru.job4j.tracker.comparator;

import ru.job4j.tracker.model.Item;

import java.util.Comparator;

/**
 * В данном классе описывается
 * сортировка по убыванию.
 *
 * Для этого достаточно поменять
 * местами first и second.
 * Таким образом результат выполнения
 * метода {@link Comparable#compareTo(Object)}
 * будет отрицательным и сортировка
 * пойдет по убыванию.
 */
public class SortByNameDescending implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return second.getName().compareTo(first.getName());
    }
}

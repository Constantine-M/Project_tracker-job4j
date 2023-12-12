package ru.job4j.tracker.comparator;

import ru.job4j.tracker.model.Item;

import java.util.Comparator;

/**
 * В данном классе описывается
 * сортировка по возрастанию.
 */
public class SortByNameAscending implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}

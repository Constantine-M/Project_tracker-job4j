package ru.job4j.tracker;

import java.util.Comparator;

/**
 * В данном классе описывается сортировка по убыванию.
 * Для этого достаточно поменять местами first и second.
 * Таким образом результат выполнения метода compareTo будет отрицательным
 * и сортировка пойдет по убыванию.
 */
public class SortByNameDescending implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return second.getName().compareTo(first.getName());
    }
}

package ru.job4j.tracker;

import java.util.Comparator;

public class SortByIdAscending implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        if (first.getId() == second.getId()) {
            return 0;
        } else if (first.getId() > second.getId()) {
            return 1;
        } else return -1;

    }
}

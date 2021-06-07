package ru.job4j.tracker;

import java.util.Comparator;

public class SortByIdDescending implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        if (first.getId() == second.getId()) {
            return 0;
        } else if (second.getId() > first.getId()) {
            return 1;
        } else return -1;
    }
}

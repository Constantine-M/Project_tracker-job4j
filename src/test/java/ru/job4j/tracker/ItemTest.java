package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.comparator.SortByIdAscending;
import ru.job4j.tracker.comparator.SortByIdDescending;
import ru.job4j.tracker.comparator.SortByNameAscending;
import ru.job4j.tracker.comparator.SortByNameDescending;
import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ItemTest {

    @Test
    public void whenSortByNameAscending() {
        List<Item> items = Arrays.asList(
                new Item("Consta"),
                new Item("Petr"),
                new Item("Stas"),
                new Item("Elena")
        );
        List<Item> rsl = Arrays.asList(
                new Item("Consta"),
                new Item("Elena"),
                new Item("Petr"),
                new Item("Stas")
        );
        List<Item> sorted = new ArrayList<>(items);
        Collections.sort(sorted, new SortByNameAscending());
        assertEquals(rsl, sorted);
    }

    @Test
    public void whenSortByNameDescending() {
        List<Item> items = Arrays.asList(
                new Item("Consta"),
                new Item("Petr"),
                new Item("Stas"),
                new Item("Elena")
        );
        List<Item> rsl = Arrays.asList(
                new Item("Stas"),
                new Item("Petr"),
                new Item("Elena"),
                new Item("Consta")
        );
        List<Item> sorted = new ArrayList<>(items);
        Collections.sort(sorted, new SortByNameDescending());
        assertEquals(rsl, sorted);
    }

    @Test
    public void whenSortByIdAscending() {
        List<Item> items = Arrays.asList(
                new Item("Consta", 1),
                new Item("Petr", 0),
                new Item("Stas", 3),
                new Item("Elena", 2)
        );
        List<Item> rsl = Arrays.asList(
                new Item("Petr", 0),
                new Item("Consta", 1),
                new Item("Elena", 2),
                new Item("Stas", 3)
        );
        List<Item> sorted = new ArrayList<>(items);
        Collections.sort(sorted, new SortByIdAscending());
        assertEquals(rsl, sorted);
    }

    @Test
    public void whenSortByIdDescending() {
        List<Item> items = Arrays.asList(
                new Item("Consta", 1),
                new Item("Petr", 0),
                new Item("Stas", 3),
                new Item("Elena", 2)
        );
        List<Item> rsl = Arrays.asList(
                new Item("Stas", 3),
                new Item("Elena", 2),
                new Item("Consta", 1),
                new Item("Petr", 0)
        );
        List<Item> sorted = new ArrayList<>(items);
        Collections.sort(sorted, new SortByIdDescending());
        assertEquals(rsl, sorted);
    }
}
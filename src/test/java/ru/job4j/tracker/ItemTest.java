package ru.job4j.tracker;

import org.hamcrest.Matcher;
import org.junit.Test;

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
//        List<Item> rsl = Arrays.asList(
//                new Item("Stas"),
//                new Item("Petr"),
//                new Item("Elena"),
//                new Item("Consta")
//        );
        List<Item> rsl = new ArrayList<>();
        rsl.add(new Item("Stas"));
        rsl.add(new Item("Petr"));
        rsl.add(new Item("Elena"));
        rsl.add(new Item("Consta"));
        List<Item> sorted = new ArrayList<>(items);
        Collections.sort(sorted, new SortByNameDescending());
        assertEquals(rsl, sorted);
    }
}
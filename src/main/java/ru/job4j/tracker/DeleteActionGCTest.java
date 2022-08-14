package ru.job4j.tracker;

/**
 * 1. Профилирование.
 *
 * @author Constantine on 09.08.2022
 */
public class DeleteActionGCTest implements UserAction {

    @Override
    public String name() {
        return "Delete items for GC test";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        for (int i = 0; i < 250000; i++) {
            tracker.delete(i);
        }
        return true;
    }
}

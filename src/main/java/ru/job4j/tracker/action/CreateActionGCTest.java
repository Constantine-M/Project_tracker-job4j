package ru.job4j.tracker.action;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.store.Store;
import ru.job4j.tracker.model.Item;

/**
 * 1. Профилирование.
 *
 * Во время тестирования использовал
 * следующие ключи:
 *
 * -XX:+UseG1GC
 * -Xmx70m
 * -Xms70m
 * -Xlog:gc:loggc.txt
 *
 * Это позволило провести успешное
 * тестирование и анлиз полученных
 * данных.
 *
 * Также были протестированы
 * и другие виды сборщиков
 * вроде Serial GC и Parallel GC.
 *
 * @author Constantine on 09.08.2022
 */
public class CreateActionGCTest implements UserAction {

    @Override
    public String name() {
        return "Create an items for GC test";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        for (int i = 0; i < 250000; i++) {
            tracker.add(new Item("item-" + i));
        }
        return true;
    }
}

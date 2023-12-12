package ru.job4j.tracker.action;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.SqlTracker;
import ru.job4j.tracker.store.Store;

/**
 * Этим интерфейсом можно описать
 * все действия системы.
 */
public interface UserAction {
    String name();

    /**
     * Метод execute возвращает boolean переменная.
     * Это нужно, чтобы создать действия выхода из программы.
     *
     * @param input переменная интерфейса Input (определяет
     *              работу класса по получению данных
     *              от пользователя в консоли.)
     * @param tracker переменная класса {@link SqlTracker}
     *                или {@link MemTracker}, которые
     *                имплементируют {@link Store}.
     * @return true or false.
     */
    boolean execute(Input input, Store tracker);
}

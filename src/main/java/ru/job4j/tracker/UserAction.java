package ru.job4j.tracker;

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
     * @param tracker переменная класса Tracker
     *                для манипуляций с заявками.
     * @return true or false.
     */
    boolean execute(Input input, Tracker tracker);
}

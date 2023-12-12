package ru.job4j.tracker.io;

/**
 * Данный интерфейс создан для того,
 * чтобы разорвать зависимость от
 * {@link System#out}.
 *
 * Он имеет 2 реализации:
 * 1.заглушка;
 * 2.консольный вывод.
 */
public interface Output {
    void println(Object obj);
}

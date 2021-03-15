package ru.job4j.tracker;

/**
 * Данный интерфейс создан для того, чтобы разорвать зависимость от system.out.
 * Он имеет 2 реализации - заглушка и консольный вывод.
 */
public interface Output {
    void println(Object obj);
}

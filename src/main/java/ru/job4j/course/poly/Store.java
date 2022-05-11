package ru.job4j.course.poly;

/**
 * Это интерфейс.
 * Интерфейс содержит определение методов, но не содержит их реализации.
 * Теперь применим эти интерфейсы к нашим хранилищам в классе Service.
 */
public interface Store {
    void save(String value);

    String[] load();
}

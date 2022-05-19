package ru.job4j.tracker;

import java.util.List;

/**
 * Данный интерфейс описывает хранилище
 * и основные методы взаимодействия
 * с заявками.
 */
public interface Store {

    Item add(Item item);

    boolean replace(int id, Item item);

    boolean delete(int id);

    List<Item> findAll();

    List<Item> findByName(String key);

    Item findById(int id);
}

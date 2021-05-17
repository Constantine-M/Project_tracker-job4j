package ru.job4j.tracker;

import java.util.List;

/**
 * Реализуем в этом классе шаблон singleton.
 * Этот класс должен реализовывать все методы от класса Tracker.
 */
public final class SingleTracker {
    /** Создал объект класса Tracker в качестве переменной поля. */
    private static Tracker tracker;
    /**
     * Создал объект внутри класса SingleTracker.
     * Поле для хранения объекта-одиночки должно быть объявлено статичным.
     */
    private static SingleTracker instance = null;

    private SingleTracker() {

    }

    /**
     * Основной статический метод (public) одиночки служит альтернативой
     * конструктору и является точкой доступа к экземпляру этого класса.
     * @return объект класса SingleTracker
     */
    public static SingleTracker getInstance() {
        if (instance == null) {
            SingleTracker.instance = new SingleTracker();
        }
        return SingleTracker.instance;
    }

    /**
     * Используя композицию объектов, добавим методы класса Tracker в данный класс.
     * Добавив объект класса Tracker, мы получили доступ к методам класса.
     * @param item объект класса Item (заявка)
     * @return добавляет заявку
     */
    public Item add(Item item) {
        return tracker.add(item);
    }

    /** Данный метод клиенты будут запускать через полученный объект одиночки.*/
    public Item findById(int id) {
        return tracker.findById(id);
    }

    /** Данный метод клиенты будут запускать через полученный объект одиночки.*/
    public List<Item> findAll() {
        return tracker.findAll();
    }
//    public Item[] findAll() {
//        return tracker.findAll();
//    }

    /** Данный метод клиенты будут запускать через полученный объект одиночки.*/
    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }
//    public Item[] findByName(String key) {
//        return tracker.findByName(key);
//    }

    /** Данный метод клиенты будут запускать через полученный объект одиночки.*/
    public boolean replace(Item item, int id) {
        return tracker.replace(id, item);
    }

    /** Данный метод клиенты будут запускать через полученный объект одиночки.*/
    public boolean delete(int id) {
        return tracker.delete(id);
    }
}

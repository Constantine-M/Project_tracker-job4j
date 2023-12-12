package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;

import java.util.List;

/**
 * Данны класс описывает шаблон singleton.
 *
 * Все реализации одиночки сводятся
 * к тому, чтобы скрыть конструктор
 * по умолчанию и создать публичный
 * статический метод, который и
 * будет контролировать жизненный
 * цикл объекта-одиночки.
 *
 * Если у вас есть доступ к
 * классу-одиночке, значит, будет
 * доступ и к этому статическому методу.
 * Из какой точки кода вы бы его
 * не вызвали, он всегда будет
 * отдавать один и тот же объект.
 *
 * Этот класс должен реализовывать
 * все методы от класса Tracker.
 */
public final class SingleTracker {

    /**
     * Создал объект класса Tracker
     * в качестве переменной поля.
     */
    private static MemTracker memTracker;

    /**
     * Создал объект внутри
     * {@link SingleTracker}.
     * Поле для хранения объекта-одиночки
     * должно быть объявлено статичным.
     */
    private static SingleTracker instance = null;

    private SingleTracker() {

    }

    /**
     * Основной статический метод (public)
     * одиночки служит альтернативой
     * конструктору и является точкой доступа
     * к экземпляру этого класса.
     *
     * @return объект {@link SingleTracker}.
     */
    public static SingleTracker getInstance() {
        if (instance == null) {
            SingleTracker.instance = new SingleTracker();
        }
        return SingleTracker.instance;
    }

    /**
     * Используя композицию объектов,
     * добавим методы класса
     * {@link MemTracker} в данный класс.
     * Добавив объект класса {@link MemTracker},
     * мы получили доступ к методам класса.
     *
     * @param item объект класса {@link Item} (заявка).
     * @return заявка.
     */
    public Item add(Item item) {
        return memTracker.add(item);
    }

    /**
     * Данный метод клиенты будут запускать
     * через полученный объект одиночки.
     */
    public Item findById(int id) {
        return memTracker.findById(id);
    }

    /**
     * Данный метод клиенты будут запускать
     * через полученный объект одиночки.
     */
    public List<Item> findAll() {
        return memTracker.findAll();
    }

    /**
     * Данный метод клиенты будут запускать
     * через полученный объект одиночки.
     */
    public List<Item> findByName(String key) {
        return memTracker.findByName(key);
    }

    /**
     * Данный метод клиенты будут запускать
     * через полученный объект одиночки.
     */
    public boolean replace(Item item, int id) {
        return memTracker.replace(id, item);
    }

    /**
     * Данный метод клиенты будут запускать
     * через полученный объект одиночки.
     */
    public boolean delete(int id) {
        return memTracker.delete(id);
    }
}

package ru.job4j.tracker;

/**
 * Реализуем в этом классе шаблон singleton.
 * Этот класс должен реализовывать все методы от класса Tracker.
 */
public final class SingleTracker {
    /** Создал объект класса Tracker в качестве переменной поля. */
    private static Tracker tracker = new Tracker();
    /** Создал объект внутри класса SingleTracker. */
    private static SingleTracker stracker = new SingleTracker();

    private SingleTracker() {

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

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(Item item, int id) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}

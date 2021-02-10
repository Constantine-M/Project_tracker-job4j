package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    /**Данное поле содержит кол-во заявлений.
     * Оно ограничено 100 позиций.
     */
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    /**Добавляет заявку, переданную в аргументах в массив заявок items.
     * С помощью setId мы проставляем уникальный ключ в объект Item item.
     * Поле ids используется для генерации нового ключа.
     * В нашем примере мы используем последовательность (то есть просто увеличиваем на 1).
     * @param item заявка
     * @return обновленный массив заявок.
     */
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    /**
     * Метод находит заявку по id.
     * Проверяем все элементы массива Item (все заявки)
     * и сравниваем их с номером id (используя метод getId() класса Item
     * и возвращаем найденный Item (у нас мы назвали rslItem).
     * Если Item не найден - возвращает null.
     * @param id номер заявки
     * @return заявку с найденным номером или null.
     */
    public Item findById(int id) {
        Item rslItem = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rslItem = item;
                break;
            }
        }
        return rslItem;
    }

    /**
     * Данный метод позволяет получить список всех заявок.
     * @return возвращает массив без нулевых значений.
     */
    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item != null) {
                itemsWithoutNull[size] = item;
                size++;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
        return itemsWithoutNull;
    }

    /**
     * Проверяем все элементы массива items (все заявки) и сравниваем с нашим именем
     * (которое в качестве аргумента метода). Используя метод getName класса Item.
     * То что находим - записываем в результирующий массив.
     * @param key имя списка
     * @return список заявок/заявку по найденному имени
     */
    public Item[] findByName(String key) {
        Item[] copyFindName = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item.getName().equals(key)) {
                copyFindName[size] = item;
                size++;
            }
        }
        copyFindName = Arrays.copyOf(copyFindName, size);
        return copyFindName;
    }
}
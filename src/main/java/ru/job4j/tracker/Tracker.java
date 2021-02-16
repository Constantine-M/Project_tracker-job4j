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
     * Доп - после того, как мы создали метод indexOf(), то методы
     * findById и indexOf стали похожи - значит поиск по id можно
     * упростить.
     * Если индекс (с помощью метода) найден, то возвращаем item, иначе null.
     */
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    /**
     * Данный метод позволяет получить список всех заявок.
     * @return возвращает массив без нулевых значений.
     * P.S. Правка - метод можно прописать в одну строку
     * (когда будешь по-новой смотреть, то знай, что тут был метод в 9 строк),
     * т.к. size - является переменной поля. То есть, когда мы создаем заявку, то
     * size уже != 0. И когда мы выводим все заявки, то мы как раз
     * выводим size заявок из пула в 100 штук (это сколько мы зарезервировали).
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    /**
     * Проверяем все элементы массива items (все заявки) и сравниваем с нашим именем
     * (которое в качестве аргумента метода). Используя метод getName класса Item.
     * То что находим - записываем в результирующий массив.
     * P.S. Доп.- по всему массиву проходить не нужно, ведь мы
     * его заполняем на size заявок, поэтому достаточно вместо items.length
     * использовать size.
     * @param key имя списка
     * @return список заявок/заявку по найденному имени
     */
    public Item[] findByName(String key) {
        Item[] copyFindName = new Item[items.length];
        int number = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getName().equals(key)) {
                copyFindName[number] = item;
                number++;
            }
        }
        return Arrays.copyOf(copyFindName, number);
    }

    /**
     * Данный метод позволяет заменить заявки.
     * Но сначала нам нужно найти ячейку, поэтому ниже прописали метод
     * для нахождения номера ячейки (индекса).
     * @param id номер заявки
     * @param item объект (заявка)
     * @return новый объект на месте старой заявки
     * Создается объект item с id = 0. А нам нужно, чтобы id не менялся.
     * P.P.S. Просто присвоил номер id.
     */
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            items[index] = item;
            item.setId(id);
            return true;
        }
        return false;
    }

    /**
     * Данный метод возвращает индекс заявки, когда мы ищем завяку по номеру id.
     * Метод объявлен как private, потому что он используется только внутри системы.
     * @param id номер заявки
     * @return индекс заявки в массиве
     */
    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}
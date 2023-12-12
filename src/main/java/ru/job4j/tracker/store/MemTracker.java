package ru.job4j.tracker.store;

import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Данный класс описывает основные
 * механизмы работы трекера.
 *
 * MemTracker - значит, что данные
 * хранятся в памяти.
 */
public class MemTracker implements Store {

    /**
     * Данное поле содержит кол-во заявлений.
     * Оно ограничено 100 позиций.
     *
     * UPDATE COLLECTION
     * Теперь мы используем коллекции.
     * В дальнейшем управление index
     * будет происходит внутри коллекции.
     */
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    /**
     * Добавляет заявку, переданную в
     * аргументах в массив заявок {@see items}.
     *
     * С помощью setId мы проставляем
     * уникальный ключ в объект {@link Item}.
     *
     * Поле ids используется для генерации
     * нового ключа. В нашем примере мы
     * используем последовательность
     * (то есть просто увеличиваем на 1).
     *
     * UPDATE COLLECTION
     * Теперь добавление заявки будет
     * осуществляться методом {@link List#add}.
     *
     * @param item заявка.
     * @return добавленная заявка {@link Item}.
     */
    @Override
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    /**
     * Данный метод позволяет заменить заявки.
     *
     * Но сначала нам нужно найти ячейку,
     * поэтому ниже прописали метод
     * для нахождения номера ячейки (индекса).
     *
     * Создается объект {@link Item} с id = 0.
     * А нам нужно, чтобы id не менялся.
     * P.S. Просто присвоил номер id.
     * P.P.S. Проверка параметров метода
     * называется ВАЛИДАЦИЕЙ.
     *
     * @param id номер заявки.
     * @param item заявка.
     * @return true, если замена была произведена
     * успешно. Иначе false.
     */
    @Override
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1 && items.get(index) != null) {
            items.set(index, item);
            item.setId(id);
            return true;
        }
        return false;

    }

    /**
     * Данный метод удаляет заявку.
     *
     * 1.Кол-во заявок size будет уменьшаться.
     * Если size не уменьшить, то тест не пройдет.
     * 2.Чтобы убрать дыру в массиве в виде
     * объекта null, мы использовали метод
     * {@link System#arraycopy}.
     *
     * Метод {@link System#arraycopy} может
     * работать с одним массивом для
     * source и dest.
     *
     * UPDATE COLLECTION
     * Здесь я сначала проверил, что удаляемая
     * запись существует. А потом, чтобы закрыть
     * дыру в списке, я пересоздал список.
     *
     * @param id номер заявки
     * @return true, если заявка удалилась,
     * или false, если заявка не была найдена по id.
     */
    @Override
    public boolean delete(int id) {
        int indexToDel = indexOf(id);
        if (indexToDel != -1) {
            items.remove(indexToDel);
            return true;
        }
        return false;
    }

    /**
     * Данный метод позволяет получить
     * список всех заявок.
     *
     * Метод можно прописать в одну строку
     * (когда будешь по-новой смотреть,
     * то знай, что тут был метод в 9 строк),
     * т.к. size - является переменной поля.
     * То есть, когда мы создаем заявку, то
     * size уже != 0. И когда мы выводим
     * все заявки, то мы как раз выводим size
     * заявок из пула в 100 штук
     * (это сколько мы зарезервировали).
     *
     * UPDATE COLLECTION
     * Ранее мы возвращали массив.
     * Теперь возвращаем коллекцию.
     *
     * @return возвращает заявки
     * без нулевых значений.
     */
    @Override
    public List<Item> findAll() {
        return new ArrayList<>(items);
    }

    /**
     * Данный метод находит все заявки
     * по указанному имени.
     *
     * 1.Проверяем все элементы массива
     * items (все заявки).
     * 2.Сравниваем с нашим именем (которое
     * в качестве аргумента метода).
     * Используем метод {@link Item#getName()}.
     * 3.То что находим - записываем в
     * результирующий массив.
     *
     * По всему массиву проходить не нужно,
     * ведь мы его заполняем на size заявок,
     * поэтому достаточно вместо items.length
     * использовать size.
     *
     * UPDATE COLLECTION
     * Проходимся по списку объектов {@link Item},
     * сравниваем поле имени с ключом key.
     * Если совпадает, то добавляем в
     * новый список объектов.
     *
     * @param key имя списка
     * @return список заявок/заявку
     * по найденному имени
     */
    @Override
    public List<Item> findByName(String key) {
        List<Item> itemsList = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemsList.add(item);
            }
        }
        return itemsList;
    }

    /**
     * Метод находит заявку по id.
     *
     * 1.Проверяем все элементы массива
     * items (все заявки).
     *
     * 2.Сравниваем их с номером id
     * (используя метод {@link Item#getId()})
     * и возвращаем найденный {@link Item}
     * (у нас мы назвали rslItem).
     *
     * 3.Если Item не найден - возвращает null.
     *
     * После того, как мы создали метод
     * {@link MemTracker#indexOf}, то методы
     * {@link MemTracker#findById} и
     * {@link MemTracker#indexOf} стали похожи.
     * Это значит, что поиск по id можно
     * упростить. Если индекс (с помощью
     * метода) найден, то возвращаем
     * {@link Item}, иначе null.
     *
     * UPDATE COLLECTION
     * Теперь возвращаем объект так:
     * items.get(index).
     *
     * @param id номер заявки
     * @return заявку с найденным
     * номером или null.
     */
    @Override
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    /**
     * Данный метод возвращает индекс заявки,
     * когда мы ищем завяку по номеру id.
     *
     * Метод объявлен как private, потому что
     * он используется только внутри системы.
     *
     * UPDATE COLLECTION
     * Теперь главное правильно ходить
     * по коллекции. Здесь в качестве
     * переменной внутри цикла использовали
     * объект класса {@link Item}.
     *
     * @param id номер заявки
     * @return индекс заявки в массиве
     */
    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}
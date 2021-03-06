package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    /**Данное поле содержит кол-во заявлений.
     * Оно ограничено 100 позиций.
     * Блок "Коллекции" - Теперь мы используем коллекции.
     * В дальнейшем управление index будет происходит внутри коллекции.
     */
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    /**Добавляет заявку, переданную в аргументах в массив заявок items.
     * С помощью setId мы проставляем уникальный ключ в объект Item item.
     * Поле ids используется для генерации нового ключа.
     * В нашем примере мы используем последовательность (то есть просто увеличиваем на 1).
     * Блок "Коллекции" - теперь добавление заявки будет осуществляться методом add интерфейса List.
     * @param item заявка
     * @return обновленный массив заявок.
     */
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
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
     * findById и indexOf стали похожи - значит поиск по id можно упростить.
     * Если индекс (с помощью метода) найден, то возвращаем item, иначе null.
     * Блок "Коллекции" - теперь возвращаем объект так: items.get(index).
     */
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    /**
     * Данный метод позволяет получить список всех заявок.
     * @return возвращает массив без нулевых значений.
     * P.S. Правка - метод можно прописать в одну строку
     * (когда будешь по-новой смотреть, то знай, что тут был метод в 9 строк),
     * т.к. size - является переменной поля. То есть, когда мы создаем заявку, то
     * size уже != 0. И когда мы выводим все заявки, то мы как раз
     * выводим size заявок из пула в 100 штук (это сколько мы зарезервировали).
     * Блок "Коллекции" - ранее мы возвращали массив. Теперь возвращаем коллекцию.
     */
    public List<Item> findAll() {
        return new ArrayList<>(items);
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
     * Блок "Коллекции" - проходимся по списку объектов items, сравниавем поле имени с ключом key.
     * Если совпадает, то добавляем в новый список объектов.
     */
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
     * Данный метод позволяет заменить заявки.
     * Но сначала нам нужно найти ячейку, поэтому ниже прописали метод
     * для нахождения номера ячейки (индекса).
     * @param id номер заявки
     * @param item объект (заявка)
     * @return новый объект на месте старой заявки
     * Создается объект item с id = 0. А нам нужно, чтобы id не менялся.
     * P.S. Просто присвоил номер id.
     * P.P.S. Проверка параметров метода называется валидацией.
     * if (index != -1) - это есть валидация.
     */
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
     * Данный метод возвращает индекс заявки, когда мы ищем завяку по номеру id.
     * Метод объявлен как private, потому что он используется только внутри системы.
     * @param id номер заявки
     * @return индекс заявки в массиве
     * Блок "Коллекции" - теперь главное правильно ходить по коллекции.
     * Здесь в качестве переменной внутри цикла использовали объект класса Item.
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

    /**
     * Данный метод удаляет заявку (объект) из массива заявок.
     * Кол-во заявок size будет уменьшаться. Если size не уменьшить, то тест не пройдет.
     * Чтобы убрать дыру в массиве в виде объекта null,
     * мы использовали метод System.array().
     * Метод System.arraycopy() может работать с одним массивом для source и dest.
     * @param id номер заявки
     * @return логическое ПРАВДА, если заявка удалилась, или ЛОЖЬ,
     * если заявка не была найдена по id.
     * P.S.А тут валидация есть. Просто она внутри условия и я бы хотел оставить так.
     * Надеюсь, что это не преступление.
     * Блок "Коллекции" - здесь я сначала проверил, то удаляемая запись существует.
     * А потом, что закрыть дыру в списке, я пересоздал список.
     */
    public boolean delete(int id) {
        int indexToDel = indexOf(id);
        if (indexToDel != -1) {
            items.remove(indexToDel);
            return true;
        }
        return false;
    }
}
package ru.job4j.tracker;

import java.util.List;

public class FindAllAction implements UserAction {

    /**
     * Создали переменную поля  в
     * виде объекта класса {@link Output}.
     *
     * В интерфейсе {@link Output}
     * есть метод {@link Output#println(Object)}.
     * Object obj - здесь имеется ввиду,
     * что там может быть объект любого
     * класса, поскольку все классы в Java
     * являются наследниками {@link Object}.
     *
     * Мы моги бы переопределить метод
     * {@link Output#println(Object)},
     * но решили внедрить его в конструктор.
     * Потому что переопределять там нечего.
     *
     * Есть предположение (оно оказалось верным),
     * что, в данном классе, тем самым
     * объектом {@link Object} будет
     * объект класса {@link String},
     * который выводит на экран фразу "Exit program".
     *
     * То есть {@link Output} будто бы съедает
     * все попавшиеся объекты и старается
     * их вывести на консоль (да, все верно).
     */
    private final Output output;

    public FindAllAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Find all Items";
    }

    /**
     * Данный метод находит все заявки.
     *
     * В данном методе ранее мы
     * создавали МАССИВ заявок.
     * А теперь используем {@link List}.
     *
     * @param input переменная интерфейса {@link Input}
     *              (определяет работу класса по
     *              получению данных от пользователя
     *              в консоли).
     * @param tracker переменная класса {@link SqlTracker}
     *                или {@link MemTracker}, которые
     *                имплементируют {@link Store}.
     * @return true, если действие выполнилось.
     */
    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("==== Create complete list ====");
        List<Item> list = tracker.findAll();
        for (Item records : list) {
            output.println(records);
        }
        return true;
    }
}

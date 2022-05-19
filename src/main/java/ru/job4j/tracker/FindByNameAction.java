package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {

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

    public FindByNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Find Item by name";
    }

    /**
     * Данный метод находит заявку по имени.
     *
     * В данном методе ранее мы
     * создавали МАССИВ заявок.
     * А теперь используем {@link List}.
     *
     * @param input переменная интерфейса Input
     *              (определяет работу класса по
     *              получению данных от пользователя
     *              в консоли).
     * @param tracker переменная класса Tracker
     *                для манипуляций с заявками.
     * @return true, если нашли заявку по имени,
     * иначе сообщение о том, что ничего не найдено.
     */
    @Override
    public boolean execute(Input input, Store tracker) {
        String nameRec = input.askStr("Enter record name: ");
        List<Item> records = tracker.findByName(nameRec);
        if (records.size() > 0) {
            for (Item recs : records) {
                output.println(recs);
            }
        } else {
                output.println("==== Records with such name not found ====");
        }
        return true;
    }
}

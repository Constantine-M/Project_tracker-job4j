package ru.job4j.tracker;

import java.util.List;

public class FindAllAction implements UserAction {
    /**
     * Создали переменную поля  в виде объекта класса Output.
     * В интерфейсе Output есть метод println(Object obj).
     * Object obj - здесь имеется ввиду, что там может быть объект любого класса,
     * поскольку все классы в Java являются наследниками Object.
     * Мы моги бы переопределить метод "println", но решили внедрить его в конструктор.
     * Потому что переопределять там нечего.
     * Есть предположение (оно оказалось верным), что, в данном классе,
     * тем самым объектом Object obj будет
     * объект класса String, который выводит на экран фразу "Exit program".
     * То есть output будто бы съедает все попавшиеся объекты и старается
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
     * Блок "Коллекции" - в данном методе ранее мы создавали массив заявок.
     * А теперь используем коллекцию.
     * @param input переменная интерфейса Input
     *              (определяет работу класса по получению данных от пользователя в консоли)
     * @param tracker переменная класса Tracker
     *                для манипуляций с заявками
     * @return
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("==== Create complete list ====");
        List<Item> list = tracker.findAll();
        for (Item records : list) {
            output.println(records);
        }
        return true;
    }
}

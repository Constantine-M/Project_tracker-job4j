package ru.job4j.tracker;

public class CreateAction implements UserAction {

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
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create a new Item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}

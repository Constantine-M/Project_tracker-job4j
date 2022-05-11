package ru.job4j.tracker;

public class ReplaceAction implements UserAction {

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

    public ReplaceAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Replace Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("==== Update item ====");
        int id = input.askInt("Enter record ID: ");
        String recName = input.askStr("New record name: ");
        Item newRec = new Item(recName);
        if (tracker.replace(id, newRec)) {
            output.println("==== Replacement successful ====");
        } else {
            output.println("==== Record ID not found ====");
        }
        return true;
    }
}

package ru.job4j.tracker;

public class CreateAction implements UserAction {
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
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create a new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}

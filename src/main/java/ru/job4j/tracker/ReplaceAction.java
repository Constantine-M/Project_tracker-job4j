package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
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

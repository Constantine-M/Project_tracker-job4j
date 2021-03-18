package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    /**
     * Создали переменную поля  в виде объекта класса Output.
     * В интерфейсе Output есть метод println(Object obj).
     * Object obj - здесь имеется ввиду, что там может быть объект любого класса,
     * поскольку все классы в Java являются наследниками Object.
     * Мы моги бы переопределить метод "println", но решили внедрить его в конструктор.
     * Потому что переопределять там нечего.
     * Есть предположение (оно оказалось верным), что, в данном классе, тем самым объектом Object obj будет
     * объект класса String, который выводит на экран фразу "Exit program".
     * То есть output будто бы съедает все попавшиеся объекты и старается их вывести на консоль (да, все верно).
     */
    private final Output output;

    public FindByNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Find Item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String nameRec = input.askStr("Enter record name: ");
        Item[] records = tracker.findByName(nameRec);
        if (records.length > 0) {
            for (Item recs : records) {
                System.out.println(recs);
            }
        } else {
            System.out.println("==== Records with such name not found ====");
        }
        return true;
    }
}

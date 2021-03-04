package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
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

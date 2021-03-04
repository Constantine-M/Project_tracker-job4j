package ru.job4j.tracker;

public class FindByIDAction implements UserAction {
    @Override
    public String name() {
        return "Find Item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idToFind = input.askInt("Enter record ID: ");
        Item findRec = tracker.findById(idToFind);
        if (findRec != null) {
            System.out.println(findRec);
        } else {
            System.out.println("==== Record with such id not found ====");
        }
        return true;
    }
}

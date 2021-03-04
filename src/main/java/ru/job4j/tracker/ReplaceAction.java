package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Replace Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Update item ====");
        int id = input.askInt("Enter record ID: ");
        String recName = input.askStr("New record name: ");
        Item newRec = new Item(recName);
        if (tracker.replace(id, newRec)) {
            System.out.println("==== Replacement successful ====");
        } else {
            System.out.println("==== Record ID not found ====");
        }
        return true;
    }
}

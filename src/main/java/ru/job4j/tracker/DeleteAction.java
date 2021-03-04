package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Removal process ====");
        int idToDel = input.askInt("Enter record ID: ");
        if (tracker.delete(idToDel)) {
            System.out.println("==== Record removed successfully ====");
        } else {
            System.out.println("==== Record ID not found ====");
        }
        return true;
    }
}

package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "Find all Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Create complete list ====");
        Item[] list = tracker.findAll();
        for (Item records : list) {
            System.out.println(records);
        }
        return true;
    }
}

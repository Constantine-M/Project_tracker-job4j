package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

/**
 * Данный класс используется для отображения
 * взаимодействия пользователя и программы.
 */
public class StartUI {
    /**
     * Данный метод отвечает за вывод меню.
     *
     * @param input для ввода информации (реализация через интерфейс)
     * @param tracker объект класса Tracker для манипуляций с заявками
     */
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            /**Вводим пункт меню от 0 до 6*/
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
            switch (select) {
                case 0:
                    StartUI.createItem(input, tracker);
                    break;
                case 1:
                    StartUI.findAllItems(tracker);
                    break;
                case 2:
                    StartUI.replaceItem(input, tracker);
                    break;
                case 3:
                    StartUI.deleteItem(input, tracker);
                    break;
                case 4:
                    StartUI.findItemByIds(input, tracker);
                    break;
                case 5:
                    StartUI.findItemByName(input, tracker);
                    break;
                case 6:
                    System.out.println("==== Shutting down ====");
                    run = false;
                    break;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }
    /**Вызов статического метода. Обращаемся через класс.*/
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("==== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void findAllItems(Tracker tracker) {
        System.out.println("==== Create complete list ====");
        Item[] list = tracker.findAll();
        for (Item records : list) {
            System.out.println(records);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("==== Update item ====");
        int id = input.askInt("Enter record ID: ");
        String recName = input.askStr("New record name: ");
        Item newRec = new Item(recName);
        if (tracker.replace(id, newRec)) {
            System.out.println("==== Replacement successful ====");
        } else {
            System.out.println("==== Record ID not found ====");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("==== Remove process ====");
        int idToDel = input.askInt("Enter record ID: ");
        if (tracker.delete(idToDel)) {
            System.out.println("==== Record removed successfully ====");
        } else {
            System.out.println("==== Record ID not found ====");
        }
    }

    public static void findItemByIds(Input input, Tracker tracker) {
        int idToFind = input.askInt("Enter record ID: ");
        Item findRec = tracker.findById(idToFind);
        if (findRec != null) {
            System.out.println(findRec);
        } else {
            System.out.println("==== Record with such id not found ====");
        }
    }
    public static void findItemByName(Input input, Tracker tracker) {
        String nameRec = input.askStr("Enter record name: ");
        Item[] records = tracker.findByName(nameRec);
        if (records.length > 0) {
            for (Item recs : records) {
                System.out.println(recs);
            }
        } else {
            System.out.println("==== Records with such name not found ====");
        }
    }
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        /**Вызов не статического метода. Необходимо обратиться через объект.*/
        new StartUI().init(input, tracker);
    }
}

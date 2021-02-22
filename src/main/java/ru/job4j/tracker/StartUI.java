package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI {
    /**
     * Данный метод отвечает за вывод меню.
     *
     * @param scanner для ввода информации
     * @param tracker объект класса Tracker для манипуляций с заявками
     */
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            /**Вводим пункт меню от 0 до 6*/
            int select = Integer.valueOf(scanner.nextLine());
            switch (select) {
                case 0:
                    System.out.println("==== Create a new Item ====");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item item = new Item(name);
                    tracker.add(item);
                    break;
                case 1:
                    System.out.println("==== Create complete list ====");
                    Item[] list = tracker.findAll();
                    for (Item records : list) {
                        System.out.println(records);
                    }
                    break;
                case 2:
                    System.out.print("Enter record ID: ");
                    int id = Integer.valueOf(scanner.nextLine());
                    System.out.print("New record name: ");
                    String recName = scanner.nextLine();
                    Item newRec = new Item(recName);
                    if (tracker.replace(id, newRec)) {
                        System.out.println("==== Replacement successful ====");
                    } else {
                        System.out.println("==== Record ID not found ====");
                    }
                    break;
                case 3:
                    System.out.print("Enter record ID: ");
                    int idToDel = Integer.valueOf(scanner.nextLine());
                    if (tracker.delete(idToDel)) {
                        System.out.println("==== Record removed successfully ====");
                    } else {
                        System.out.println("==== Record ID not found ====");
                    }
                    break;
                case 4:
                    System.out.print("Enter record ID: ");
                    int idToFind = Integer.valueOf(scanner.nextLine());
                    Item findRec = tracker.findById(idToFind);
                    if (findRec != null) {
                        System.out.println(findRec);
                    } else {
                        System.out.println("==== Record with such id not found ====");
                    }
                    break;
                case 5:
                    System.out.print("Enter record name: ");
                    String nameRec = scanner.nextLine();
                    Item[] records = tracker.findByName(nameRec);
                    if (records.length > 0) {
                        for (Item recs : records) {
                            System.out.println(recs);
                        }
                    } else {
                        System.out.println("==== Records with such id not found ====");
                    }
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
        System.out.print("Select: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}

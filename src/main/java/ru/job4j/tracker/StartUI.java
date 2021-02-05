package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        Item item = new Item();
        String dateTime = item.getLocalDateTime().format(formatter);
        System.out.println(dateTime);
        System.out.println(item);
    }
}

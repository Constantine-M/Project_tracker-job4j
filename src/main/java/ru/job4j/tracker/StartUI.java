package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        Item item = new Item();
        String dateTime = item.getLocalDateTime().format(formatter);
        System.out.println(dateTime);
        /**
         * Получается изначально нет смысла назначать заявке номер,
         * так как она будет назначена автоматом в методе
         * добавления заявки.
         */
        item.setName("Mayday");
        item.setId(2);
        Item secondItem = new Item("Friday", 3);
        Tracker request = new Tracker();
        request.add(item);
        request.add(secondItem);
        request.findById(2);
        System.out.println(request.findById(2));
    }
}

package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    /**Добавил поле типа LocalDateTime класса Item и сразу же
     * проинициализировал его датой и временем (текущим), используя
     * статический метод .now().
     */
    private LocalDateTime created = LocalDateTime.now();
    private int id;
    private String name;

    /**Создали конструктор без входных параметров*/
    public Item() {

    }

    /**
     * Создали конструктор с параметром id.
     * @param id номер.
     */
    public Item(int id) {
        this.id = id;
    }

    /**
     * Методом перегрузки конструктора, создал
     * новый конструктор уже с входным параметром.
     * @param name имя объекта.
     * @param id номер.
     */
    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**Добавили геттер, чтобы получить доступ к полю created.*/
    public void getLocalDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String dateTime = created.format(formatter);
        System.out.println(dateTime);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
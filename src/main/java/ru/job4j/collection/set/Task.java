package ru.job4j.collection.set;

/**
 * 1. Уникальные задачи.
 * Данный класс описывает задачу, у которой есть номер и описание/название.
 */
public class Task {
    private String number;
    private String description;

    public Task(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
}

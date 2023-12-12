package ru.job4j.tracker.model;

import lombok.Data;
import ru.job4j.tracker.action.CreateActionGCTest;
import ru.job4j.tracker.store.SqlTracker;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Данный класс описывает модель заявления.
 * id - это уникальный номер.
 *
 * UPD.12.12.23 - генерация get(), set()
 * методов и методов equals()/hashcode()
 * выполнена с помощью библиотеки Lombok,
 * используя аннотацию {@link Data}.
 */
@Data
public class Item {

    private int id;

    private String name;

    private LocalDateTime created = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

    /**
     * Данный конструктор требуется для
     * функционирования тестов.
     */
    public Item() {

    }

    /**
     * Данный конструктор требуется для
     * функционирования тестов.
     */
    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Методом перегрузки параметров
     * создали конструктор с
     * входным параметром name.
     *
     * Данный конструктор требуется для
     * функционирования класса
     * {@link CreateActionGCTest}.
     *
     * @param name имя заявки
     */
    public Item(String name) {
        this.name = name;
    }

    /**
     * Данный конструктор необходим для
     * функционирования класса
     * {@link SqlTracker}.
     */
    public Item(int id, String name, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }
}
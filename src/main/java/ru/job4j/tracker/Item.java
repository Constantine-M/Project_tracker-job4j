package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Данный класс описывает модель заявления.
 * id - это уникальный номер.
 */
public class Item {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private int id;

    private String name;

    /**
     * Добавил поле типа {@link LocalDateTime}
     * класса Item и сразу же проинициализировал
     * его датой и временем (текущим), используя
     * статический метод
     * {@link LocalDateTime#now()}.
     */
    private LocalDateTime created = LocalDateTime.now();

    /**
     * Создали конструктор без
     * входных параметров
     */
    public Item() {

    }

    /**
     * Создали конструктор с параметром id.
     *
     * @param id номер.
     */
    public Item(int id) {
        this.id = id;
    }

    /**
     * Методом перегрузки конструктора,
     * создал новый конструктор уже
     * с входным параметром.
     *
     * @param name имя объекта.
     * @param id номер.
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
     * @param name имя заявки
     */
    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    /**
     * Добавили геттер, чтобы получить
     * доступ к полю {@link Item#created}.
     */
    public LocalDateTime getLocalDateTime() {
        return created;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return String.format("id: %s, name: %s, created: %s", id, name, FORMATTER.format(created));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id
                && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
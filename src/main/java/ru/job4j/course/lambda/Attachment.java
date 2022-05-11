package ru.job4j.course.lambda;

/**
 * 1.1. Анонимные классы.
 * Данный класс - модель данных, с которой
 * будем работать по задаче.
 * Нам нужно отсортировать эту модель по полю size.
 */
public class Attachment {
    private String name;
    private int size;

    public Attachment(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Attachment{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }
}

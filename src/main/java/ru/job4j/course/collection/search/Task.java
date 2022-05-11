package ru.job4j.course.collection.search;

/**
 * Данный класс связан с задачей "Очередь с приоритетом на LinkedList".
 * Класс описывает задачу, у который есть описание и уровень важности.
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}

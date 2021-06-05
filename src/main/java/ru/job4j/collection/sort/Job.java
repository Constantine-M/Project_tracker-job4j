package ru.job4j.collection.sort;

import org.jetbrains.annotations.NotNull;

/**
 * 0. Сортировка.
 * Данный класс - это модель данных. Он описывает работу, у которой имеется имя и приоритет.
 * Нам нужно написать сортировку для этого класса.
 * Для этого мы в этом классе реализуем интерфейс java.util.Comparable<Job>.
 */
public class Job implements Comparable<Job> {
    private String name;

    private int priority;

    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }

    @Override
    public int compareTo(Job another) {
        return Integer.compare(priority, another.priority);
    }
}

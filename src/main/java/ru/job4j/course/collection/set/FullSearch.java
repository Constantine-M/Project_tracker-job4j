package ru.job4j.course.collection.set;

import java.util.HashSet;
import java.util.List;

/**
 * 1. Уникальные задачи.
 * Данный класс описывает варианты поиска. В нашей задаче мы проверяем
 * список задач и устраняем дубликаты.
 * Как оказалось, дубликаты ищутся по полю (в этом случае - это номер).
 */
public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task number : list) {
            numbers.add(number.getNumber());
        }
        return numbers;
    }
}

package ru.job4j.stream.school;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 1. Фильтрация учеников.
 * Данный класс описывает школу
 * и все что в ней происходит.
 */
public class School {

    /**
     * Данный метод позволяет произвести
     * сортировку учеников по среднему баллу.
     * В ланном задании мы испольуем
     * Stream API и методы {@code filter()} и
     * {@code collect()}.
     * А в тесте, в предикате описываем условие
     * и передаем в метод. Сам метод универсальный.
     * @param students список студентов.
     * @param predict условие
     *                распределения по классам.
     * @return список учеников
     * которые удовлетворяют условию сортировки.
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }
}

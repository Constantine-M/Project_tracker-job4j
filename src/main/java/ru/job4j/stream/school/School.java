package ru.job4j.stream.school;

import java.util.List;
import java.util.Map;
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

    /**
     * Данный метод преобразует список
     * учеников в карту, где ключ -
     * это Фамилия ученика.
     * Т.к. в списке были дублирующие
     * записи, был использован метод
     * {@code distinct()} и тест
     * успешно завершался. Также в JavaDoc пишут:
     * If the mapped keys
     * might have duplicates, use {@code toMap(
     * Function, Function, BinaryOperator)} instead.
     * Под {@code BinaryOperator} означает,
     * что здесь мы должны придумать
     * функцию, которая позволит нам
     * исключить дубликат ключа.
     * Например, мы можем выбрать наименьшее значение
     * из этих 2х ключей. Свой вариант я
     * закомментировал - он не поддается объяснению.
     * По умолчанию метод {@code toMap}
     * возвращает HashMap!
     * Если нужна другая карта, то используй
     * {@code #toMap(Function, Function,
     * BinaryOperator, Supplier)}.
     * @param students список студентов.
     * @return карту студентов.
     */
    public Map<String, Student> collectToMap(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(Collectors.toMap(
                        Student::getSurname,
                        student -> student));
//                        (student, student2) -> student));
    }
}

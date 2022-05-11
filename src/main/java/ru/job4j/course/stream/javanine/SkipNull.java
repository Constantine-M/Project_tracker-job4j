package ru.job4j.course.stream.javanine;

import java.util.List;
import java.util.stream.Stream;

/**
 * 0. Stream API улучшения.
 * Данный класс описывает метод
 * {@code ofNullable}.
 * Этот метод позволяет фильтровать
 * поток с null элементами.
 */
public class SkipNull {
    /**
     * Метод возвращает поток.
     * Если элемент потока == null,
     * то пропускает его.
     * Здесь с помощью метода
     * {@code flatMap} мы объединяем
     * исходный стрим с пустым стримом
     * и возвращаем стрим, к которому
     * применем метод {@code ofNullable},
     * котороый в свою очередь
     * возвращает ненулевой стрим.
     */
    public static void main(String[] args) {
        List.of(1, null, 2, null, 3).stream()
                .flatMap(Stream::ofNullable)
                .map(v -> "Результат: " + v)
                .forEach(System.out::println);
    }
}

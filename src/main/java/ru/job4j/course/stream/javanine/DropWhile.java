package ru.job4j.course.stream.javanine;

import java.util.List;

/**
 * 0. Stream API улучшения.
 * Данный класс описывает метод
 * {@code dropWhile}.
 * Этот метод позволяет получать
 * поток данных после того,
 * как условие стало ложным.
 */
public class DropWhile {
    /**
     * Проще говоря: "Если условие/
     * предикат == ЛОЖЬ, то
     * отобрази на консоли."
     */
    public static void main(String[] args) {
        List.of(1, 2, 3, 4).stream()
                .dropWhile(v -> v < 3)
                .map(v -> "Результат: " + v)
                .forEach(System.out::println);
    }
}

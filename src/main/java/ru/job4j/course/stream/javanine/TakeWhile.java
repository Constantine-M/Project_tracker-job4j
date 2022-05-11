package ru.job4j.course.stream.javanine;

import java.util.List;

/**
 * 0. Stream API улучшения.
 * Данный класс описывает метод
 * {@code takeWhile}.
 * Этот метод позволяет получать поток
 * данных до тех пор, пока условие истина.
 */
class TakeWhile {
    /**
     * Когда число становится равным 3,
     * то поток отбрасывается.
     * Эту конструкцию удобно использовать
     * с отсортированными данными.
     */
    public static void main(String[] args) {
        List.of(1, 2, 3, 4).stream()
                .takeWhile(v -> v < 3)
                .map(v -> "Результат: " + v)
                .forEach(System.out::println);
    }
}

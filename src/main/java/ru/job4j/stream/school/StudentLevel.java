package ru.job4j.stream.school;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 0. Stream API улучшения.
 * Данный класс демонстрирует
 * использование новых методов
 * в Stream API.
 */
public class StudentLevel {
    /**
     * Данный метод позволяет найти
     * студентов, у которых балл в
     * аттестате выше определенного балла.
     * Во время сортировки используем
     * метод {@code comparing()}.
     * В скобках указываем
     * (ЧТО_СРАВНИВАЕМ, КАК_СРАВНИВАЕМ),
     * то есть какой компаратор используем
     * для сравнения и соответственно
     * сортировки (если он нужен).
     * Если бы мы не использовали
     * метод {@code reversed()}, то
     * цикл бы даже не начинался, т.к.
     * сортировка происходит от мин до макс.
     * @param students список студентов.
     * @param bound пограничный балл.
     * @return отфильтрованный список студентов.
     */
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((left, right) -> Integer.compare(right.getScore(), left.getScore()))
                .takeWhile(student -> student.getScore() > bound)
                .collect(Collectors.toList());
    }
}

package ru.job4j.stream.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 5. Преобразование матрицы чисел в список чисел.
 * Данный класс описывает варианты применения
 * метода flatMap.
 */
public class UsageFlatMap {

    /**
     * Данный метод преобразовывает двумерный
     * массив в список чисел.
     * Используется Stream API и метод
     * {@code flatMap()}, который
     * принимает элемент потока и преобразовывает
     * его в новый поток.
     * Метод Stream.of() - returns a sequential ordered
     * stream whose elements are the specified values.
     * В нашем случае (массивы) нужно использовать
     * {@code Arrays.stream()}.
     * Таким образом, мы каждую строку
     * двумерного массива преобразовали в stream,
     * а потом добавили в список.
     * @param matrix двумерный массив.
     * @return список чисел этого массива.
     */
    public List<Integer> convert(Integer[][] matrix) {
        return Arrays.stream(matrix)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}

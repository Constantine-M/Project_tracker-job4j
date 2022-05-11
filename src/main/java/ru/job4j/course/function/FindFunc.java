package ru.job4j.course.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 5. Подсчет функции в диапазоне.
 * Данный класс описывает общую
 * функцию, которую можно изменять.
 */
public class FindFunc {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            double value = i;
            list.add(func.apply(value));
        }
        return list;
    }
}

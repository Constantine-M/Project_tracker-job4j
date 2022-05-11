package ru.job4j.course.lambda.lambdabasics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 2.2. Лямбда блок.
 * Данный класс описывает правильную
 * организацию лямбда блока.
 */
public class LambdaUsage {
    /**
     * Данный метод описывает сортировку
     * по убыванию длины строки.
     * Внимание строится на написании
     * лямбда блока.
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Anna");
        list.add("Barbara");
        list.add("Clear");
        System.out.println("Before sorting: " + list);
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + right.length() + ":" + left.length());
            return Integer.compare(right.length(), left.length());
        };
        list.sort(cmpDescSize);
        System.out.println("After sorting: " + list);
    }
}

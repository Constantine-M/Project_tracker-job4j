package ru.job4j.collection.departments;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Задача 2. Отсортировать департаменты.
 * Данный класс позволяет добавлять пропущенные подразделения,
 * а также производить сортировку подразделений.
 */
public class Departments {
    /**
     * Данный метод заполняет пробелы в структуре.
     * Алгоритм работы следующий:
     * 1.Каждую входящую строку нужно разбить на одиночные элементы.
     * Для этого можно использовать метод {@code String.split("/")}.
     * Этот метод вернет массив одиночных элементов.
     * 2.Далее нужно через цикл последовательно складывать
     * элементы и добавлять их в множество.
     * @param deps список подразделений.
     * @return дополненный список подразделений.
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> temp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                boolean adding = (start.equals("")) ? temp.add(start = el) : temp.add(start + "/" + el);
             }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> orgs) {

    }

    public static void sortDesc(List<String> orgs) {

    }
}

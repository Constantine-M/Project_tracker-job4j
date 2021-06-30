package ru.job4j.collection.departments;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    /**
     * Данный метод сравнивает 2 строки
     * для сортировки по убыванию.
     * Для этого мы с помощью метода {@code compareTo()}
     * класса String савнили 2 строки.
     * @param o1 первая строка.
     * @param o2 вторая строка.
     * @return 0, 1 или -1.
     */
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}

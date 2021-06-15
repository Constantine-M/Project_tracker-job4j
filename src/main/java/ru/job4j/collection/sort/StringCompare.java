package ru.job4j.collection.sort;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    /**
     * Данны метод сравнивает 2 списка поэлементно.
     * Здесь мы циклом проходим по спискам. Длину выбрал наименьшую, т.к.
     * с наибольшей выходит Out of bound Ex.
     * Вынес в отдельные переменные символы в списках с помощью charAt().
     * Чтобы начать сравнивать, нужно, чтобы символы не были одинаковыми.
     * С помощью Character.getNumericValue() мы преобразовали символ в число,
     * а потом эти числа сравнили с помощью Integer.compare().
     * Результать нам вернет 1 или -1. А если списки равны, то во втором return
     * мы просто вычтем длины. Так как они одинаковые (слова), то мы получим 0.
     * @param left первый список.
     * @param right второй список.
     * @return возвращает 0, 1 или -1.
     */
    @Override
    public int compare(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        for (int index = 0; index < minLength; index++) {
            char a = left.charAt(index);
            char b = right.charAt(index);
            if (a != b) {
                return Integer.compare(Character.getNumericValue(a), Character.getNumericValue(b));
            }
        }
        return left.length() - right.length();
    }
}

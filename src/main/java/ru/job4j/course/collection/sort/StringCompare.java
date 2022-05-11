package ru.job4j.course.collection.sort;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    /**
     * Данны метод сравнивает 2 списка поэлементно.
     * Здесь мы циклом проходим по спискам. Длину выбрал наименьшую, т.к.
     * с наибольшей выходит Out of bound Ex.
     * Вынес в отдельные переменные символы в списках с помощью charAt().
     * Поскольку в Java для представления символов в строках используется кодировка Unicode,
     * разрядность типа char в этом языке — 16 бит.
     * Хотя величины типа char и не используются, как целые числа, вы можете оперировать
     * с ними так, как если бы они были целыми.
     * В данной задаче уместнее и экономнее использовать метод Character.compare().
     * Результать нам вернет 1 или -1. А если списки равны, то во втором return
     * мы воспользуемся Integer.compare(). Так как они одинаковые (слова), то мы получим 0.
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
                return Character.compare(a, b);
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}

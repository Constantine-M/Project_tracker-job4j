package ru.job4j.collection.departments;

import java.util.*;

public class DepDescComp implements Comparator<String> {
    /**
     * Данный метод сравнивает 2 строки
     * для сортировки по убыванию.
     * Сначала мы разбили эти строки,
     * далее сравнили первые элементы.
     * Если они равны, то сравниваем
     * так чтоб убывало. Если не равны,
     * то сравниваем так чтоб возрастало.
     * @param o1 первая строка.
     * @param o2 вторая строка.
     * @return 0, 1 или -1.
     */
    @Override
    public int compare(String o1, String o2) {
        ArrayList<String> first = new ArrayList<>();
        ArrayList<String> second = new ArrayList<>();
        first.addAll(Arrays.asList(o1.split("/")));
        second.addAll(Arrays.asList(o2.split("/")));
        return first.get(0) != second.get(0) ?
                o1.compareTo(o2) :
                o2.compareTo(o1);
        }
}

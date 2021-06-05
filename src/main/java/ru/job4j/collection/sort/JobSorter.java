package ru.job4j.collection.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    /**
     * В классе Job мы переопределили метод compare to.
     * Теперь сравнение будет происходит по той логике, которую мы опишем.
     * На текущий момент метод сравнения работает по дефолту, т.к. мы используем метод сравнения в
     * встроенных типах данных.
     * А в последней строке мы уже переделали сортировку и придумали свою - по имени.
     * Для этого использовали отдельный класс и переопределили нужные нам методы
     * интерфейса Comparator.
     */
    public static void main(String[] args) {
        List<Job> tasks = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        System.out.println(tasks);
        Collections.sort(tasks);
        System.out.println(tasks);
        System.out.println("Sort via Comparator:");
        Collections.sort(tasks, new SortByNameJob());
    }
}

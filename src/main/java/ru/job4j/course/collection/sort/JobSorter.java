package ru.job4j.course.collection.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 6. Функции высшего порядка.
 * Данный класс описывает варианты сортировки
 * с использованием компаратора.
 * А также класс используется как пример
 * для объяснения функции высшего порядка.
 * Функции высшего порядка - это функции,
 * зависящие от других функций.
 * В программировании функции высшего порядка
 * описываются через композицию.
 */
public class JobSorter {
    /**
     * В классе Job мы переопределили метод compare to.
     * Теперь сравнение будет происходит по той
     * логике, которую мы опишем.
     * На текущий момент метод сравнения работает
     * по дефолту, т.к. мы используем метод сравнения в
     * встроенных типах данных.
     * А в последней строке мы уже переделали сортировку
     * и придумали свою - по имени.
     * Для этого использовали отдельный класс и переопределили
     * нужные нам методы интерфейса Comparator.
     * 62 строка: В интерфейсе Comparator есть метод с
     * реализацией по умолчанию  {@code thenComparing}.
     * Этот метод принимает другой компаратор.
     * Таким образом, можно соединить или
     * скомбинировать любую сортировку.
     * 76 строка: Чтобы вычислить значение combine, нужно
     * сначала вычислить значение compareName,
     * а потом comparePriority.
     * Объект combine - это функция высшего порядка.
     */
    public static void main(String[] args) {
        List<Job> tasks = Arrays.asList(
                new Job("Reboot server", 1),
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Task", 0)
        );
        System.out.println(tasks);
        Collections.sort(tasks);
        System.out.println(tasks);
        System.out.println("Sort via Comparator:");
        Collections.sort(tasks, new SortByNameJob());
        System.out.println(tasks);
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 1),
                new Job("Fix bugs", 4),
                new Job("Fix bugzz", 2),
                new Job("Task", 0)
        );
        Collections.sort(jobs, new JobDescByName().thenComparing(new JobDescByPriority()));
        System.out.println(jobs);
        System.out.println("Ниже комбинированный компаратор:");
        Collections.sort(jobs, new JobDescByNameLn()
                .thenComparing(new JobDescByName()
                .thenComparing(new JobDescByPriority())));
        System.out.println(jobs);
        List<Job> test = Arrays.asList(
                new Job("A", 5),
                new Job("B", 4),
                new Job("C", 3),
                new Job("D", 2),
                new Job("E", 1)
        );
        Collections.sort(test, new JobAscByName());
        System.out.println(test);

        Comparator<Job> compareName = Comparator.comparing(Job::getName);
        Comparator<Job> comparePriority = Comparator.comparingInt(Job::getPriority);
        Comparator<Job> combine = compareName.thenComparing(comparePriority);
    }
}

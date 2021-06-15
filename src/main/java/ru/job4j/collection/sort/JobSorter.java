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
        System.out.println("В интерфейсе Comparator есть метод с реализацией по " + System.lineSeparator() +
                "умолчанию - thenComparing. Этот метод принимает другой компаратор." + System.lineSeparator()+
                        "Таким образом, можно соединить или скомбинировать любую сортировку.");
        Collections.sort(jobs, new JobDescByName().thenComparing(new JobDescByPriority()));
        System.out.println(jobs);
        System.out.println("Создадим комбинированный компаратор: " + System.lineSeparator() +
                "сортировка по длине имени, по имени и приоритету.");
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
    }
}

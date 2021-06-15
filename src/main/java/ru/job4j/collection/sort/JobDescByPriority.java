package ru.job4j.collection.sort;

import java.util.Comparator;

public class JobDescByPriority implements Comparator<Job> {
    /**
     * Чтобы обеспечить сортировку по убыванию, в компараторе
     * мы сравниваем второй параметр с первым, а в случае
     * сортировки по возрастанию - первый со вторым.
     */
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o2.getPriority(), o1.getPriority());
    }
}

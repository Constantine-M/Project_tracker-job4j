package ru.job4j.collection.search;

import java.util.LinkedList;

/**
 * Данный класс связан с задачей "Очередь с приоритетом на LinkedList".
 * Он описывает работу простейшей очереди по приоритету, которая работает
 * по принципу FIFO (first in - first out)
 * @author CONSTANTINE MEZENIN
 * @version 1.0
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод принимает на вход заявку и добавляет ее в очередь.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать {@code add(int index, E value)}.
     * Здесь мы сравниваем приоритеты элемента {@code element}, который уже
     * находится в списке, и самой задачи (task), которую
     * передаем в аргумент метода put.
     * В этом уроке нужно вернуть задачу {@code task} с самым высоким приоритетом.
     * Чем выше {@code priority}, тем ниже приоритет задачи.
     * Если {@code priority} у нашей задачи {@code task} выше, чем {@code priority}
     * у задач в списке, то index увеличить, чтобы эта задача ушла ниже,
     * благодаря увеличивающемуся индексу в списке (т.к. приоритет ниже).
     * Например. Приоритет - 1 - самый высокий, а 5 - самый низкий.
     * @param task задача которая добавляется в очередь
     */
    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (element.getPriority() < task.getPriority()) {
                index++;
                break;
            }
        }
        this.tasks.add(index, task);
    }

    /**
     * Данный метод возвращает задачу, которая находится первой в списке.
     * После метода {@link #put}, этот метод вернет самую важную задачу (если я все верно понял).
     * @return возвращает задачу из головы очереди или null если очередь пуста.
     */
    public Task take() {
        return tasks.poll();
    }
}

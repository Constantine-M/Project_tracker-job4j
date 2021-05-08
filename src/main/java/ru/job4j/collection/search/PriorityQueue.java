package ru.job4j.collection.search;

import java.util.LinkedList;

/**
 * Данный класс связан с задачей "Очередь с приоритетом на LinkedList".
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * Здесь мы сравниваем приоритеты элемента (element), который уже находится в списке,
     * и самой задачи (task), которую передаем в аргумент метода put.
     * В этом уроке нужно вернуть задачу task с самым высоким приоритетом.
     * Чем выше priority, тем ниже приоритет задачи.
     * Если priority у нашей задачи (task) выше, чем priority у задач в списке,
     * то index увеличить, чтобы эта задача ушла ниже, благодаря увеличивающемуся индексу в списке
     * (т.к. приоритет ниже).
     * Например. Приоритет - 1 - самый высокий, а 5 - самый низкий.
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (element.getPriority() < task.getPriority()) {
                index++;
            }
        }
        this.tasks.add(index, task);
    }

    /**
     * Данный метод возвращает задачу, которая находится первой в списке.
     * После метода put, этот метод вернет самую важную задачу (если я все верно понял).
     * @return самая приоритетная задача.
     */
    public Task take() {
        return tasks.poll();
    }
}

package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 0. Stream API.
 * Данный класс описывает общие возможности
 * интерфейса Stream.
 */
public class StreamUsage {
    /**
     * Данный класс описывает задачу.
     * Нам необходимо отфильтровать все задачи,
     * где в имени есть слово "Bug"  и
     * сохранить их в коллекцию.
     */
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{"
                    + "name='" + name + '\''
                    + ", spent=" + spent
                    + '}';
        }
    }

    /**
     * Пройдем по первым строкам блока main.
     * 1.{@code tasks.stream()} позволяет
     * получить из коллекции Stream или поток элементов.
     * 2.метод {@code .filter()} - если возвращает true,
     * то элемент передается дальше.
     * 3.Метод filter() принимает объект Predicate<Task>.
     * 4.Далее задаем условие с помощью
     * лямбды (что объект содержит "Bug").
     * 5.{@code .collect(Collectors.toList())}
     * позволяет полученный результат сохранить
     * в коллекции типа List.
     * 6. {@code tasks.stream().map()}
     * - данный метод используется для
     * преобразования. В метод map передается
     * определенная функция.
     * 7.{@code .reduce(0L, Long::sum)} -
     * каждое значение task.spent складывает
     * с начальным значением - 0L.
     * 8.Stream конструкции принято переносить
     * на новую строку. Так легче читать код!
     */
    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 10),
                new Task("Task #2", 20),
                new Task("Bug #3", 40)
        );
        System.out.println("Задача:");
        tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .filter(task -> task.spent > 30)
                .map(task -> task.name + " " + task.spent)
                .forEach(System.out::println);

        System.out.println("1.Фильтрация:");
        List<Task> bugs = tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .collect(Collectors.toList());
        bugs.forEach(System.out::println);
        System.out.println("2.Преобразование:");
        List<String> container = tasks.stream()
                .map(task -> task.name)
                .collect(Collectors.toList());
        container.forEach(System.out::println);
        System.out.println("3.Упрощение:");
        long total = tasks.stream()
                .map(task -> task.spent)
                .reduce(0L, Long::sum);
        System.out.println(total);
        System.out.println("Display only positive:");
        List<Integer> numbers = List.of(2, -9, 1, 4, 3, -5, 6);
        List<Integer> positiveNum = numbers.stream()
                .filter(number -> number > 0)
                .collect(Collectors.toList());
        positiveNum.forEach(System.out::println);
    }
}

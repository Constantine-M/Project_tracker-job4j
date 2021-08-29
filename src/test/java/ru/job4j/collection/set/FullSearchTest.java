package ru.job4j.collection.set;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FullSearchTest {
    /**
     * Данный тест как раз покажет, что в новом списке нет дубликатов.
     * Коллекции Set хранят только уникальные элементы.
     * Между собой элементы сравниваются в HashSet через метод equals.
     * У класса java.lang.String метод equals переопределен,
     * поэтому мы можем его корректно использовать с коллекцией HashSet.
     */
    @Test
    public void when4ElemetsThen3() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("1", "task1"));
        tasks.add(new Task("1", "task1"));
        tasks.add(new Task("2", "task2"));
        tasks.add(new Task("3", "task3"));
        Set<String> expected = new HashSet<>(List.of("1", "2", "3"));
        assertThat(FullSearch.extractNumber(tasks), is(expected));
    }

    /**
     * Этот тест нужен был для эксперимента.
     * Интересный момент вышел: когда вместо "numbers.add(number.getNumber());"
     * я добавил "numbers.add(number.getDescription());", то список Set начал искать дубли
     * в поле "description". Тест оставлю, геттер тоже.
     */
    @Test
    public void when5ElemetsThen3() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("1", "task1"));
        tasks.add(new Task("2", "task1"));
        tasks.add(new Task("2", "task2"));
        tasks.add(new Task("3", "task3"));
        tasks.add(new Task("4", "task4"));
        tasks.add(new Task("5", "task4"));
        Set<String> expected = new HashSet<>(List.of("1", "2", "3", "4", "5"));
        assertThat(FullSearch.extractNumber(tasks), is(expected));
    }
}
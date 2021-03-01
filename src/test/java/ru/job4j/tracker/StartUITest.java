package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        String[] answers = {"Consta"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Consta");
        assertThat(created.getName(), is(expected.getName()));

    }

    /**
     * Создаем предполагаемый ответ пользователя - String[] answers = {"FX PC"};
     * Создаем объект класса StubInput с аргументом answers, эмулируя ввод инфы пользователя.
     * Создаем заявку - StartUI.createItem(input, tracker);
     * Данная заявка в массиве имеет индекс = 0. Это всё, что должен найти наш проверяемый метод.
     * Согласно методу, мы должны найти все заявки. А так как создали одну, то
     * expected = <создать эту самую заявку> - = new Item("FX PC");
     * Сравниваем created и expected.
     */
    @Test
    public void whenFindAllItems() {
        String[] answers = {"FX PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("FX PC");
        assertThat(created.getName(), is(expected.getName()));
    }
}
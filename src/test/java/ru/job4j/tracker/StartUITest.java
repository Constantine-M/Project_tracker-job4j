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
        /**Здесь нужно как-то записать созданный объект в переменную класса Item.
         * Я не знаю как, потому что сам метод ничего не возвращает.*/
        /**А если сравнивать, то сравнивать с пустой ячейкой (чтоб понять, что заявка создалась)
         * или же сравнивать по имени как в следующем методе*/
        /**Кажется, что этот тест копирует следующий тест.*/
        assertThat(Item item, is(notNullValue()));

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
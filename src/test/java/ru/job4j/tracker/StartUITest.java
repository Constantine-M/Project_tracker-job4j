/**package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
/**
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

    /**
     * 1. Создаем объект tracker.
     * 2. Создаем объект item.
     * 3. Добавляем item в tracker. После этой операции у нас есть id.
     * 4. Достаем item.id и создаем массив с ответами пользователя.
     * 5. Вызываем тестируемый метод replaceItem. Это действие изменит состояние объекта tracker.
     * 6. Ищем по item.id замененный item в объекте tracker.
     * 7. Сравниваем имя найденной заявки с ожидаемой.
     */
    /**
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "replaced Item"
        };
        StartUI.replaceItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced Item"));
    }
/**
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String[] answer = {
                String.valueOf(item.getId())
        };
        StartUI.deleteItem(new StubInput(answer), tracker);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted, is(nullValue()));
    }
}*/
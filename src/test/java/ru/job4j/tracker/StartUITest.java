package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StartUITest {
    /**
     * Для понимания, как написан тест.
     * "0", "Item name", "1" - эта строка есть алгоритм действий.
     * То есть {0, 1} - это индексы массива с действиями, который мы написали ниже.
     * UserAction[] actions = {2 действия} - то есть мы действия задали сами.
     * Нам ведь нужно только создать и выйти.
     * "Item name" - это то, что будет создано после действия "0" (создание).
     * Input in = new StubInput(new String[] {то что пользователь введет} - здесь мы
     * эмулируем ввод пользователя. То есть именно в таком порядке он будет выбирать пункт (создание),
     * называть элемент и выбирать 1 для выхода.
     */
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
                );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    /**
     * 1. Эмулируем ввод, создав последовательность ввода данных в виде массива
     * {создать - имя - заменить - выйти}.
     * 2. Создаем объект класса Tracker.
     * 3. Создаем массив действий, которые будем/хотим совершить.
     * 4. Создаем объект класса StartUI и вызываем у него метод init с аргументами
     * (in, tracker, actions), которые описывают ввод, методы над заявками и действиям (ввиду использования интерфейса)
     * 5. Сравниваем имя найденной заявки с ожидаемой.
     */
    @Test
    public void whenReplaceItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1", "1", "Replaced Item", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ReplaceAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Replaced Item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted Item"));
        Input in = new StubInput(new String[]
                {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    /**
     * Тест максимально поход на создание заявки.
     */
    @Test
    public void whenFindAllItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("FX PC find all"));
        Input in = new StubInput(new String[]
                {"0", "1"}
                );
        UserAction[] actions = {
                new FindAllAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("FX PC find all"));
    }
}
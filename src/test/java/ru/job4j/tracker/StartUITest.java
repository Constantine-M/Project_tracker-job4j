package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StartUITest {

    /**
     * Из нового: мы разорвали зависимость от
     * {@link System#out} и создали интерфейс
     * {@link Output}.
     *
     * О тесте.
     * 1. Сначала мы создали объект класса
     * {@link StubOutput} (заглушка), чтобы
     * симитировать выход/завершение программы.
     * 2. Создали объект класса {@link StubInput},
     * чтобы симитировать ввод.
     * Все, что мы введем - это нулевое - первое и
     * единственное действие в массиве действий программы.
     * 3. Создали массив действий.
     * 4. Инициализировали работу класса {@link StartUI}.
     * Обрати внимание, что конструктор класса
     * поменялся - добавили ({@link Output}).
     * 5. Сравниваем с тем, что должно получиться.
     */
    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input input = new StubInput(new String[]
                {"0"});
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(input, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0.Exit program" + System.lineSeparator()
        ));
    }

    /**
     * Для понимания, как написан тест.
     * "0", "Item name",
     * "1" - эта строка есть алгоритм действий.
     * То есть {0, 1} - это индексы массива с
     * действиями, который мы написали ниже.
     * UserAction[] actions = {2 действия} - то есть
     * мы действия задали сами. Нам ведь нужно
     * только создать и выйти.
     * "Item name" - это то, что будет создано
     * после действия "0" (создание).
     * Input in = new StubInput(new String[]
     * {то что пользователь введет} - здесь мы
     * эмулируем ввод пользователя. То есть именно
     * в таком порядке он будет выбирать пункт (создание),
     * называть элемент и выбирать 1 для выхода.
     */
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
                );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("Item name"));
    }

    /**
     * 1. Эмулируем ввод, создав последовательность
     * ввода данных в виде массива.
     * {создать - имя - заменить - выйти}.
     * 2. Создаем объект класса Tracker.
     * 3. Создаем массив действий, которые
     * будем/хотим совершить.
     * 4. Создаем объект класса {@link StartUI} и
     * вызываем у него метод {@link StartUI#init}
     * с аргументами (in, tracker, actions), которые
     * описывают ввод, методы над заявками
     * и действиям (ввиду использования интерфейса)
     * 5. Сравниваем имя найденной заявки с ожидаемой.
     */
    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Replaced Item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "Replaced Item", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("Replaced Item"));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Deleted Item"));
        Input in = new StubInput(new String[]
                {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    /**
     * Тест максимально похож на создание заявки.
     */
    @Test
    public void whenFindAllItems() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("FX PC find all"));
        Input in = new StubInput(new String[]
                {"0", "1"}
                );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindAllAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0.Find all Items" + System.lineSeparator()
                        + "1.Exit program" + System.lineSeparator()
                        + "==== Create complete list ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0.Find all Items" + System.lineSeparator()
                        + "1.Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Consta"));
        Input in = new StubInput(new String[]
                {"0", String.valueOf(item.getId()), "1"}
                );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIDAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0.Find Item by ID" + System.lineSeparator()
                        + "1.Exit program" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0.Find Item by ID" + System.lineSeparator()
                        + "1.Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Consta"));
        Input in = new StubInput(new String[]
                {"0", item.getName(), "1"}
                );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0.Find Item by name" + System.lineSeparator()
                        + "1.Exit program" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0.Find Item by name" + System.lineSeparator()
                        + "1.Exit program" + System.lineSeparator()
        ));
    }

    /**
     * Данный тест показывает работу сценария,
     * когда пользователь вводит неправильный
     * пункт меню, а именно тот пункт,
     * которого нет в списке.
     * 1. Сначала программа отображает меню
     * и предлагает выбор.
     * 2.Мы вводим номер пункта из списка
     * доступных действий.
     * 3.Если неверно, то мы ожидаем сообщение:
     * "Wrong input, you can select: 0 .. 0".
     * 4.Возвращаемся к списку.
     * 5.Выбираем правильный пункт.
     */
    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input input = new StubInput(new String[]
                {"2", "0"}
                );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        String ln = System.lineSeparator();
        new StartUI(out).init(input, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0.Exit program" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0.Exit program" + ln
        ));
    }
}
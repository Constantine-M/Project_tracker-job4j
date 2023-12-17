package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.io.*;
import ru.job4j.tracker.logger.Log4File;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.SqlTracker;
import ru.job4j.tracker.store.Store;

import java.util.List;

/**
 * Данный класс используется для
 * отображения взаимодействия
 * пользователя и программы.
 *
 * UPDATE
 * Разрывая зависимость от
 * {@link System#out}, вносим
 * изменения с помощью конструктора
 * (интерфейс {@link Output}).
 *
 * Чтобы запустить программу, убедитесь,
 * что у вас создана БД. Я создал
 * БД с именем "tracker".
 */
public class StartUI {

    /**
     * Создали переменную поля
     * в виде объекта (композиция).
     */
    private final Output out;

    /**
     * Общий (на все приложение) объект
     * класса {@link Output} будем внедрять
     * через конструктор.
     *
     * @param out объект, который нужно
     *            вывести на консоль
     */
    public StartUI(Output out) {
        this.out = out;
    }

    /**
     * Данный метод отвечает за вывод меню.
     *
     * this.showMenu(actions) - после этого
     * мы вводим пункт меню от 0 до 6.
     *
     * UPDATE
     * Теперь в метод мы передаем не
     * массив, а коллекцию.
     *
     * @param input для ввода информации
     *              (реализация через интерфейс).
     * @param tracker объект класса {@link SqlTracker}
     *                или {@link MemTracker}.
     * @param actions массив действий с заявками
     *                (реализация через интерфейс).
     */
    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    /**
     * Переписали метод отображения
     * списка действий, т.к. действия
     * теперь уложены в массив.
     *
     * UPDATE
     * Теперь в метод мы передаем не
     * массив, а коллекцию.
     *
     * @param actions массив действий
     *                с заявками.
     */
    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
           out.println(index + "." + actions.get(index).name());
        }
    }

    /**
     * Все статические методы
     * (действия), которые здесь были,
     * перекочевали в отдельные классы
     * для изоляции методов друг от
     * друга и, тем самым, улучшения
     * гибкости программы.
     *
     * 1.Создаем объект класса {@link Log4File}
     * и получаем его методы.
     * 2.Создаем массив с действиями.
     * 3.Вызов нестатического метода.
     * Необходимо обратиться через объект.
     *
     * Input input = new ValidateInput(
     * output, new ConsoleInput()); - в данной
     * строке использовали ДЕКОРАТОР.
     *
     * UPDATE
     * Массив с действиями изменили
     * на коллекцию.
     */
    public static void main(String[] args) {
        Log4File log = Log4File.getInstance();
        log.add("New Item");
        log.save();
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        try (SqlTracker tracker = new SqlTracker()) {
            tracker.init();
            List<UserAction> actions = List.of(
                    new CreateAction(output),
                    new FindAllAction(output),
                    new ReplaceAction(output),
                    new DeleteAction(output),
                    new FindByIDAction(output),
                    new FindByNameAction(output),
                    new ExitAction(output)
            );
            new StartUI(output).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
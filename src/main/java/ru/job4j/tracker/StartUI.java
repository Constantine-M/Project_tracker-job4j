package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Данный класс используется для отображения взаимодействия пользователя и программы.
 * Разрывая зависимость от System.out, вносим изменения с помощью конструктора (интерфейс Output).
 */
public class StartUI {

    /**
     * Создали переменную поля в виде объекта.
     */
    private final Output out;

    /**
     * Общий (на все приложение) объект класса Output будем внедрять через конструктор.
     * @param out объект, который нужно вывести на консоль
     */
    public StartUI(Output out) {
        this.out = out;
    }

    /**
     * Данный метод отвечает за вывод меню.
     * this.showMenu(actions) - после этого мы вводим пункт меню от 0 до 6.
     * Блок "Коллекции" - теперь в метод мы передаем не массив, а коллекцию.
     * @param input для ввода информации (реализация через интерфейс)
     * @param tracker объект класса Tracker для манипуляций с заявками
     * @param actions массив действий с заявками (реализация через интерфейс)
     */
    public void init(Input input, Tracker tracker, List<UserAction> actions) {
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
//        while (run) {
//            this.showMenu(actions);
//            int select = input.askInt("Select: ");
//            if (select < 0 || select >= actions.length) {
//                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
//                continue;
//            }
//            UserAction action = actions[select];
//            run = action.execute(input, tracker);
    }

    /**
     * Переписали метод отображения списка действий, т.к. действия теперь уложены в массив.
     * Блок "Коллекции" - теперь в метод мы передаем не массив, а коллекцию.
     * @param actions массив действий с заявками
     */
    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (UserAction action : actions) {
            out.println(actions.indexOf(action) + "." + action.name());
        }
//        for (int index = 0; index < actions.length; index++) {
//           out.println(index + "." + actions[index].name());
//        }
    }

    /**Все статические методы (действия), которые здесь были,
     * перекочевали в отдельные классы для изоляции методов друг от друга
     * и, тем самым, улучшения гибкости программы.
     * Начало - Создаем объект класса Log4File и получаем его методы.
     * Середина - Создаем массив с действиями.
     * Концовка - Вызов нестатического метода. Необходимо обратиться через объект.
     * Input input = new ValidateInput(output, new ConsoleInput()); - в данной строке использовали ДЕКОРАТОР.
     * Блок "Коллекции" - массив с действиями переделываем в коллекцию.
     */
    public static void main(String[] args) {
        Log4File log = Log4File.getInstance();
        log.add("New Item");
        log.save();
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new FindAllAction(output));
        actions.add(new ReplaceAction(output));
        actions.add(new DeleteAction(output));
        actions.add(new FindByIDAction(output));
        actions.add(new FindByNameAction(output));
        actions.add(new ExitAction(output));
//        UserAction[] actions = {
//                new CreateAction(output),
//                new FindAllAction(output),
//                new ReplaceAction(output),
//                new DeleteAction(output),
//                new FindByIDAction(output),
//                new FindByNameAction(output),
//                new ExitAction(output)
//        };
        new StartUI(output).init(input, tracker, actions);
    }
}

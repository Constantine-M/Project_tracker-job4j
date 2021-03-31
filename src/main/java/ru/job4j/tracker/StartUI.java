package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

/**
 * Данный класс используется для отображения
 * взаимодействия пользователя и программы.
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
     *
     * @param input для ввода информации (реализация через интерфейс)
     * @param tracker объект класса Tracker для манипуляций с заявками
     * @param actions массив действий с заявками (реализация через интерфейс)
     */
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            /**Вводим пункт меню от 0 до 6*/
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    /**
     * Переписали метод отображения списка действий, т.к. действия теперь уложены в массив.
     * @param actions массив действий с заявками
     */
    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
           out.println(index + "." + actions[index].name());
        }
    }

    /**Вызов статического метода. Обращаемся через класс.*/
    /**Все статические методы (действия), которые здесь были,
     * перекочевали в отдельные классы для изоляции методов друг от друга
     * и, тем самым, улучшения гибкости программы.
     */
    public static void main(String[] args) {
        /**Создаем объект класса Log4File и получаем его методы.*/
        Log4File log = Log4File.getInstance();
        log.add("New Item");
        log.save();
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        /**Создаем массив с действиями*/
        UserAction[] actions = {
                new CreateAction(output),
                new FindAllAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindByIDAction(output),
                new FindByNameAction(output),
                new ExitAction(output)
        };
        /**Вызов не статического метода. Необходимо обратиться через объект.*/
        new StartUI(output).init(input, tracker, actions);
    }
}

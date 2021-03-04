package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

/**
 * Данный класс используется для отображения
 * взаимодействия пользователя и программы.
 */
public class StartUI {
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
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    /**
     * Переписали метод отображения списка действий, т.к. действия теперь уложены в массив.
     * @param actions массив действий с заявками
     */
    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + "." + actions[index].name());
        }
    }

    /**Вызов статического метода. Обращаемся через класс.*/
    /**Все статические методы (действия), которые здесь были,
     * перекочевали в отдельные классы для изоляции методов друг от друга
     * и, тем самым, улучшения гибкости программы.
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        /**Создаем массив с действиями*/
        UserAction[] actions = {
                new CreateAction(),
                new FindAllAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindByIDAction(),
                new FindByNameAction(),
                new ExitAction()
        };
        /**Вызов не статического метода. Необходимо обратиться через объект.*/
        new StartUI().init(input, tracker, actions);
    }
}

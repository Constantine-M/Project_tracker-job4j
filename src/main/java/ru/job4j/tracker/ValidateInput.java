package ru.job4j.tracker;

/**
 * Данный класс расширяет возможности класса ConsoleInput, потому что...
 * В методе ConsoleInput.askInt предусмотрены НЕ ВСЕ действия пользователя.
 * Давайте добавим в него нужное поведение за счет механизма переопределения (override).
 * Данный класс предостерегает от некорректного ввода. В нашем случае от
 * ввода вместо числа - текста.
 */
public class ValidateInput extends ConsoleInput {
    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}

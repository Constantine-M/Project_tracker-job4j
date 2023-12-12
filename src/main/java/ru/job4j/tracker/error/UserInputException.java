package ru.job4j.tracker.error;

/**
 * {@link Exception} имеет конструктор по умолчанию.
 *
 * Petr Arsentev рекомендует
 * всегда добавлять конструктор с текстом.
 *
 * При использовании вашего исключения
 * нужно будет добавить детальную
 * информацию о возникновении исключения,
 * а не просто получить пустой вывод.
 */
public class UserInputException extends Exception {

    public UserInputException(String message) {
        super(message);
    }
}

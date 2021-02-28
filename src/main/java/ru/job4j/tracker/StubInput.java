package ru.job4j.tracker;

/**
 * Доработаем этот класс так, чтобы метод askStr возвращал параметры, которые мы хотим.
 * Это нужно для написания тестов.
 * Добавим в этот класс поле с вариантами ответов пользователя.
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}

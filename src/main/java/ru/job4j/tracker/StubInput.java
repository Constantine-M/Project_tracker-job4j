package ru.job4j.tracker;

/**
 * implements Input - эта строчка заставляет нас в классе StubInput создать те же методы,
 * что и в интерфейсе Input и добавить в них реализацию.
 */
public class StubInput implements Input {
    @Override
    public String askStr(String question) {
        return null;
    }

    @Override
    public int askInt(String question) {
        return 0;
    }
}

package ru.job4j.tracker;

/**
 * Данный класс используется для вывода информации на консоль.
 */
public class ConsoleOutput implements Output {
    /**
     * В данном методе важно правильно прописать именно System.out.println (а не println как раньше),
     * иначе выходит ошибка StackOverFlow.
     * @param obj объект класса Object. Все классы Java являются наследниками класса Object.
     */
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}

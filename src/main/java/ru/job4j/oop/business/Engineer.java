package ru.job4j.oop.business;

/**Сделаем класс Engineer на основании класса Profession.
 * Чтобы наследовать один класс от другого,
 * нужно после имени класса написать ключевое слово extends
 * и далее указать, какой класс нужно наследовать.
 */
public class Engineer extends Profession {
    private Profession admin;
    private int experience;

    public Engineer() {
        super(name);
    }

    public Troubleshoot problem(Engineer man) {

    }
}

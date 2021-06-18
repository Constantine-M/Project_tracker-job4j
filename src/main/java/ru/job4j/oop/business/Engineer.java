package ru.job4j.oop.business;

import java.time.LocalDate;

/**Сделаем класс Engineer на основании класса Profession.
 * Чтобы наследовать один класс от другого,
 * нужно после имени класса написать ключевое слово extends
 * и далее указать, какой класс нужно наследовать.
 */
public class Engineer extends Profession {
    /**Создал поле, коорое будет заполнено значением
     * кол-во опыта работы. Данное поле будет присуще
     * только объектам класса Engineer.
     */
    private int experience;

    /**
     * В данном конструкторе мы указали параметры родительского класса
     * и текущего класса Engineer.
     * С помощью super() мы вызвали конструктор суперкласса
     * (родительского класса) и смогли обратиться к его параметрам.
     * А ниже инициализировали поля, которые есть в классе-наследнике - Engineer.
     */
    public Engineer(String name, String surname, String education,
                    LocalDate birthday, int experience) {
        super(name, surname, education, birthday);
        this.experience = experience;
    }

    /** Этот метод должен вернуть объект класса Troubleshoot.
     * Приходит авария инженеру. Инженер ее решает
     * и возвращает решение класса Troubleshoot.
     */
    public Troubleshoot crash(Alarm alarm) {
        Troubleshoot solution = new Troubleshoot();
        return solution;
    }
}
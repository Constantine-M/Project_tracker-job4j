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
    public Engineer(String name, String surname, String education, LocalDate birthday, int experience) {
        super(name, surname, education, birthday);
        this.experience = experience;
    }

    /**Пока не понимаю, как работает этот метод!
     * Знаю, что в качестве аргумента выступает объект класса Alarm.
     * А мы обращаемся к объекту класса Troubleshoot, но зачем?
     * И что он фактически должен возвращать?
     * Какой объект мы здесь должны создать?
     */
    public Troubleshoot crash(Alarm alarm) {
        Troubleshoot trouble = new Troubleshoot();
        return trouble;
    }
}
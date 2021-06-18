package ru.job4j.oop.business;

import java.time.LocalDate;

/**Сделаем класс Programmer на основании класса Engineer.
 * Чтобы наследовать один класс от другого,
 * нужно после имени класса написать ключевое слово extends
 * и далее указать, какой класс нужно наследовать.
 */
public class Programmer extends Engineer {

    /**Создал поле, которое будет заполнено значением языка,
     * которым владеет программист. Например - Java.
     * Данное поле будет описывать объект класса Programmer.
     */
    private String language;

    /**
     * В данном конструкторе мы указали параметры родительского класса
     * и текущего класса Programmer.
     * С помощью super() мы вызвали конструктор суперкласса
     * (родительского класса) и смогли обратиться к его параметрам.
     * А ниже инициализировали поля, которые есть в классе-наследнике - Programmer.
     */
    public Programmer(String name, String surname, String education,
                      LocalDate birthday, int experience, String language) {
        super(name, surname, education, birthday, experience);
        this.language = language;
    }

    /**Данный метод закрывает задачу.
     * Входным параметров выступает объект класса Task.
     * @param task входящий параметр (задача).
     */
    public void closeTask(Task task) { }
}

package ru.job4j.course.oop.business;

import java.time.LocalDate;

/**Сделаем класс Dentist на основании класса Doctor.
 * Чтобы наследовать один класс от другого,
 * нужно после имени класса написать ключевое слово extends
 * и далее указать, какой класс нужно наследовать.
 */
public class Dentist extends Doctor {
    /**Данное поле класса Dentist будет заполнено значением
     * "инструмент".
     */
    private String tool;

    /**
     * В данном конструкторе мы указали параметры родительского класса
     * и текущего класса Dentist.
     * С помощью super() мы вызвали конструктор суперкласса
     * (родительского класса) и смогли обратиться к его параметрам.
     * А ниже инициализировали поля, которые есть в классе-наследнике - Dentist.
     */
    public Dentist(String name, String surname, String education,
                   LocalDate birthday, String certificate, String tool) {
        super(name, surname, education, birthday, certificate);
        this.tool = tool;
    }

    /**
     * Метод лечит зуб. Входящим параметром выступает объект класса Patient.
     * @param patient пациент.
     */
    public void treatTooth(Patient patient) {
    }
}

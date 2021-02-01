package ru.job4j.oop.business;

import java.time.LocalDate;

/**Сделаем класс Surgeon на основании класса Doctor.
 * Чтобы наследовать один класс от другого,
 * нужно после имени класса написать ключевое слово extends
 * и далее указать, какой класс нужно наследовать.
 */
public class Surgeon extends Doctor {
    /**Данное поле будет заполнено значением
     * области работы хирурга - нейрохрургия или
     * кардиохирург например.
     * Поле будет описывать объект класса Surgeon.
     */
    private String type;

    /**
     * В данном конструкторе мы указали параметры родительского класса
     * и текущего класса Dentist.
     * С помощью super() мы вызвали конструктор суперкласса
     * (родительского класса) и смогли обратиться к его параметрам.
     * А ниже инициализировали поля, которые есть в классе-наследнике - Dentist.
     */
    public Surgeon(String name, String surname, String education, LocalDate birthday, String certificate, String type) {
        super(name, surname, education, birthday, certificate);
        this.type = type;
    }

    /**В данном методе хирург зашивает порез.
     * Входящим параметром выступает объект класса Patient.
     * @param patient пациент.
     */
    public void sewCut(Patient patient) {}
}

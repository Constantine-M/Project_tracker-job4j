package ru.job4j.oop.business;

import java.time.LocalDate;

/**Сделаем класс Doctor на основании класса Profession.
 * Чтобы наследовать один класс от другого,
 * нужно после имени класса написать ключевое слово extends
 * и далее указать, какой класс нужно наследовать.
 */
public class Doctor extends Profession {
    /**Данное поле будет заполнено значением
     * (название сертификата) и принадлежать объектам класса Doctor.
     */
    private String certificate;

    /**
     * В данном конструкторе мы указали параметры родительского класса
     * и текущего класса Engineer.
     * С помощью super() мы вызвали конструктор суперкласса
     * (родительского класса) и смогли обратиться к его параметрам.
     * А ниже инициализировали поля, которые есть в классе-наследнике - Doctor.
     */
    public Doctor(String name, String surname, String education, LocalDate birthday, String certificate) {
        super(name, surname, education, birthday);
        this.certificate = certificate;
    }

    /**Пока не понимаю, как работает этот метод!
     * Знаю, что в качестве аргумента выступает объект класса Patient.
     * А мы обращаемся к объекту класса Diagnosis, но зачем?
     * И что он фактически должен возвращать?
     * Какой объект мы здесь должны создать?
     */
    public Diagnosis heal(Patient patient) {
        Patient girl = new Patient();
        return null;
    }
}

package ru.job4j.course.oop.business;

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
     * и текущего класса Doctor.
     * С помощью super() мы вызвали конструктор суперкласса
     * (родительского класса) и смогли обратиться к его параметрам.
     * А ниже инициализировали поля, которые есть в классе-наследнике - Doctor.
     */
    public Doctor(String name, String surname, String education,
                  LocalDate birthday, String certificate) {
        super(name, surname, education, birthday);
        this.certificate = certificate;
    }

    /**Этот метод должен вернуть объект класса Diagnosis.
     * Пациент это класс, объектами которого являются пациенты.
     * Диагноз класс, объекты которого- диагноз.
     * Пациент приходит к доктору, получает диагноз
     */
    public Diagnosis heal(Patient patient) {
        Diagnosis diag = new Diagnosis();
        return diag;
    }
}

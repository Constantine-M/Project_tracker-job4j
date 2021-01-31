package ru.job4j.oop.business;

import java.time.LocalDate;

/**Данный класс будет родительским.
 * В нем будут общие поля и методы.
 */
public class Profession {
    private String name;
    private String surname;
    private String education;
    private LocalDate birthday;

    public Profession(String name, String surname, String education, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    /**Создал геттер, который возвращает имя объекта*/
    public String getName() {
        return name;
    }
}

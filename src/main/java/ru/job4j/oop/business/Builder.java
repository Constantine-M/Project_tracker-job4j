package ru.job4j.oop.business;


import java.time.LocalDate;

/**Сделаем класс Builder на основании класса Engineer.
 * Чтобы наследовать один класс от другого,
 * нужно после имени класса написать ключевое слово extends
 * и далее указать, какой класс нужно наследовать.
 */
public class Builder extends Engineer {

    /** Создал поле, которое будет заполнено значением типа
     * строения, которые возводит строитель.
     * Например дом или очередной энергоблок атомной станции.
     * Данное поле будет описывать объект класса Builder.
     */
    private String typeOfBuild;

    /**
     * В данном конструкторе мы указали параметры родительского класса
     * и текущего класса Programmer.
     * С помощью super() мы вызвали конструктор суперкласса
     * (родительского класса) и смогли обратиться к его параметрам.
     * А ниже инициализировали поля, которые есть в классе-наследнике - Programmer.
     */
    public Builder(String name, String surname, String education, LocalDate birthday, int experience, String typeOfBuild) {
        super(name, surname, education, birthday, experience);
        this.typeOfBuild = typeOfBuild;
    }

    /** Данный метод собирает дом по чертежу.
     * В качесвте входящих данных выступает объект класса Figure.
     * @param figure объект чертеж.
     */
    public void construct(Figure figure) {}
}
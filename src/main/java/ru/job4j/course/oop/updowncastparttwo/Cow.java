package ru.job4j.course.oop.updowncastparttwo;

public class Cow extends DomesticAnimal {
    /**
     * Данный метод отображает действие объекта класса Cow.
     */
    public void giveMilk() {
        System.out.println(getNameClass() + " дает человеку молоко.");
    }
}

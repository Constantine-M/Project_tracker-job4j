package ru.job4j.oop.updowncastparttwo;

public class Goose extends DomesticAnimal {
    /**
     * Данный метод отображает действие объекта класса Goose.
     */
    public void bringFeather() {
        System.out.println(getNameClass() + " приносит перо для подушек.");
    }
}

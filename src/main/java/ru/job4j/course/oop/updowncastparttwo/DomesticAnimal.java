package ru.job4j.course.oop.updowncastparttwo;

public class DomesticAnimal extends Animal {
    /**
     * Метод отображает действие объекта класса DomesticAnimal (одомашненного животного).
     */
    public void liveOnFarm() {
        System.out.println(getNameClass() + " живет на ферме, приносит пользу.");
    }
}

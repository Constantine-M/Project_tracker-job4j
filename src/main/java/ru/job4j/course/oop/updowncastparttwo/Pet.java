package ru.job4j.course.oop.updowncastparttwo;

public class Pet extends Animal {
    /**
     * Метод отображает действие питомца.
     */
    public void vaccinate() {
        System.out.println(getNameClass() + " нуждается в прививках, чтобы не болеть.");
    }
}

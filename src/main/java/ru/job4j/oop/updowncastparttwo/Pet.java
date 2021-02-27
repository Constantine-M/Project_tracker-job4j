package ru.job4j.oop.updowncastparttwo;

public class Pet extends Animal {
    /**
     * Метод отображает действие питомца.
     */
    public void vaccinate() {
        System.out.println(nameClass + " нуждается в прививках, чтобы не болеть.");
    }
}

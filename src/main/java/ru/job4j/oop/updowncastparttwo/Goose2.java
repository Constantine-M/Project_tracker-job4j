package ru.job4j.oop.updowncastparttwo;

public class Goose2 implements Anima {
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " произносит звук: Га-га.");
    }
}

package ru.job4j.oop.updowncastparttwo;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летит по воздуху.");
    }

    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " бибикает, чтобы пугать птиц.");
    }
}

package ru.job4j.course.oop.updowncastparttwo;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + " несется на полной скорости, пролетая все дорожные ухабы.");
    }

    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName()
                + " нервно бибикает, потому что пробка.");
    }
}

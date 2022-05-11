package ru.job4j.course.oop.updowncastparttwo;

public class Dog2 implements Anima {
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " произносит звук: Гав-гав.");
    }
}

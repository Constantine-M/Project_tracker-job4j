package ru.job4j.course.oop.updowncastparttwo;

public class Cow2 implements Anima {
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " произносит звук: Му-му.");
    }
}

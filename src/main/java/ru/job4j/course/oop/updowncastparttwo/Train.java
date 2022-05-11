package ru.job4j.course.oop.updowncastparttwo;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " мчится по рельсам.");
    }

    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName()
                + " бибикает, гудит, поднимая дым и пугая индусов.");
    }
}

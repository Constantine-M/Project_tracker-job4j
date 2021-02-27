package ru.job4j.oop.updowncastparttwo;

public class GuineaPig2 implements Anima {
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " громко пищит для привлечения внимания.");
    }
}

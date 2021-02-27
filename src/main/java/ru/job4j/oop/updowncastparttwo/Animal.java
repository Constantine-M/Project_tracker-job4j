package ru.job4j.oop.updowncastparttwo;

public class Animal {
    String nameClass = getClass().getSimpleName();
    /**
     * Данный метод отображает звук, издаваемый объектом родительского класса.
     */
    public void sound() {
        System.out.println(nameClass + " - издает какой-то звук.");
    }
}

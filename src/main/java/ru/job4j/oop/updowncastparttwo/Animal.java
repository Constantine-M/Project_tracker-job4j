package ru.job4j.oop.updowncastparttwo;

public class Animal {
    private String nameClass;

    public String getNameClass() {
        return getClass().getSimpleName();
    }

    /**
     * Данный метод отображает звук, издаваемый объектом родительского класса.
     */
    public void sound() {
        System.out.println(getNameClass() + " - издает какой-то звук.");
    }
}

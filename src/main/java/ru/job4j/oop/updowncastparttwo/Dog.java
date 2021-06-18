package ru.job4j.oop.updowncastparttwo;

public class Dog extends Pet {
    /**
     * Данный метод отображает действие объекта Dog.
     */
    public void runAfterCat() {
        System.out.println(getNameClass() + " не любит кошек, постоянно за ними гоняется.");
    }
}

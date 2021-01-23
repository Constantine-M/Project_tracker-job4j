package ru.job4j.oop;

public class Student {
    /**
     * Чтобы научить студента играть, создадим метод.
     * Он должен находиться внутри тела класса.
     */
    public void music() {
        System.out.println("Tra-tra-tra");
    }

    /**А теперь научим студента петь.
     * Таким же образом напишем метод внутри тела класса.
     */
    public void song() {
        System.out.println("I believe I can fly");
    }
    /**
     * Чтобы вызвать метод, нужно обратиться к переменной petya объекта класса Student.
     * petya - это и есть объект. Но к объекту нужно обращаться так же как и везде - через переменную.
     */
    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.song();
        petya.music();
        petya.song();
        petya.music();
        petya.song();
    }
}

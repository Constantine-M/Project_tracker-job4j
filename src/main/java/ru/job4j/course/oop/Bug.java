package ru.job4j.course.oop;

public class Bug {
    private String name;

    /**Это код, который описывает конструктор.*/
    public Bug(String text) {
        name = text;
    }
    /**Теперь, чтобы создать объекта класса Bug, нужно указать параметр у конструктора. */

    public static void main(String[] args) {
        String issue = "FIX me ASAP.";
        Bug item = new Bug(issue);
        /**В методе main мы вызываем конструктор - Bug().
         * Это конструктор по умолчанию. В нем нет аргументов.
         * Так мы можем делать, если у нас не создан конструктор.
         */
        /**В нашем случае конструктор создан, поэтому нужно указать параметр
         * Bug item = new Bug(issue);
         */
    }
}

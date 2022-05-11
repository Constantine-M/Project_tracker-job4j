package ru.job4j.course.oop.updowncast;

public class College {
    public static void main(String[] args) {
        Freshman man = new Freshman();
        /**Делаем приведение к типу родителя Student - up casting.*/
        Student student = man;
        /**Делаем приведение к типу родителя Object - up casting.*/
        Object obj = man;

    }
}

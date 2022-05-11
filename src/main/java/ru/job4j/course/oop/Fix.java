package ru.job4j.course.oop;

public class Fix {
    private String desc;

    public Fix(String text) {
        desc = text;
    }

    public static void main(String[] args) {
        String solution = "Bug fixed successfully";
        /**Создали объект item класса Fix, который содержит
         * текстовую информацию - один из параметров класса Fix*/
        Fix item = new Fix(solution);
    }
}

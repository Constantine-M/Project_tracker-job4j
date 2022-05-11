package ru.job4j.course.ex;

import java.util.Arrays;

public class BackArray {
    public static void main(String[] args) {
        String[] names = {"Petr", "Ivan", "Nik", "Vasya"};
        int middle = names.length / 2;
        /**вместо <= поставил "<"*/
        for (int i = 0; i < middle; i++) {
            String temp = names[i];
            /**в 2 строках к "names.length - i" дописал " - 1"*/
            names[i] = names[names.length - i - 1];
            names[names.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(names));
    }
}

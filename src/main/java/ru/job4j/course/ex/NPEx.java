package ru.job4j.course.ex;

public class NPEx {
    public static void main(String[] args) {
        String[] shop = new String[5];
        shop[0] = "Consta";
        for (int i = 0; i < shop.length; i++) {
            String el = shop[i];
            /**
             * Без "if" было бы так:
             * исключение падает, так как мы заполнили только первую ячейку в массиве,
             * а остальные по умолчанию заполняются null ссылками.
             * Чтобы избежать NPE, необходимо проверять на null!!!
             */
            if (el != null) {
                System.out.println(el + " has a size : " + el.length());
            }
        }
    }
}

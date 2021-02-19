package ru.job4j.io;

import java.util.Scanner;
/**С помощью данного класса можно выводить рандомные варианты/ответы*/
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать?");
        int value = new Random().nextInt(3);
        String question = input.nextLine();
        switch (value) {
            case 0:
                System.out.println("Yep");
                break;
            case 1:
                System.out.println("Nope");
                break;
            default:
                System.out.println("Может быть");
                break;
        }
    }
}

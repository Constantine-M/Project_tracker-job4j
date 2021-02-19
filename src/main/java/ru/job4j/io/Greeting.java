package ru.job4j.io;

/**Мы будем использовать объект класса сканер, поэтому импортировали класс*/
import java.util.Scanner;

/**
 * Сделаем программу которая просит ввести имя и поприветствует нас.
 */
public class Greeting {
    public static void main(String[] args) {
        /**Объект класса Scanner принимает в качестве параметра объект "System.in".*/
        Scanner input = new Scanner(System.in);
        System.out.println("Добро пожаловать. Как Вас зовут?");
        /**Метод nextLine(), который считывает все символы
         * строки после нажатия на клавишу Enter.
         * Когда мы вызываем этот метод в коде, программа останавливается
         * и ждет, пока пользователь введет символы в консоль.
         */
        String name = input.nextLine();
        /**Все, что мы введем ранее, будет записано в переменную name*/
        System.out.println(name + ", glad to see You!");
    }
}

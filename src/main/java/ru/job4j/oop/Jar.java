package ru.job4j.oop;

public class Jar {
    /**Создадим поле value класса Jar.
     * В данном поле будет указано кол-во воды.
     */
    private int value;

    /**Добавим конструктор для инициализации начального состояния сосуда.*/
    public Jar(int size) {
        this.value = size;
    }

    /**Добавим в класс Jar метод, который будет принимать объект типа Jar.
     * another - это есть, например, второй объект (сосуд) со своими нач. параметром.
     * Сначала добавили из 2-го в 1-ый. Потом объем первого обнулили.*/
    public void pour(Jar another) {
        this.value = this.value + another.value;
        another.value = 0;
    }

    /**Для демонстрации метод main.
     * Как ты отметил, мы ранее создали описание класс "Сосуд" (Jar) и описали его,
     * указав на то, что он имеет начальный размер (size).
     * У объекта first вызываем метод pour.
     * С помощью метода pour мы добавили в первый сосуд содержимое второго сосуда.
     */
    public static void main(String[] args) {
        Jar first = new Jar(10);
        Jar second = new Jar(5);
        System.out.println("first : " + first.value + ". second : " + second.value);
        first.pour(second);
        System.out.println("first : " + first.value + ". second : " + second.value);
    }

}

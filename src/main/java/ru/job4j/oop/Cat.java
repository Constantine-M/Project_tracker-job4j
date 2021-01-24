package ru.job4j.oop;

public class Cat {
    /**Создадим поле food класса Cat.
     * Все поля мы описываем внутри класса. Локальные переменные мы создаем внутри метода.
     * Private относится к теме "сокрытие информации".
     */
    private String food;

    /**Создадим доп поле name класса Cat*/
    private String name;

    /**Создадим метод, в котором присваиваем полю name значение nick.
     * То есть даем кличку котику.
     */
    public void giveNick(String nick) {
        this.name = nick;
    }
    /**Создадим метод eat с параметром meat типа String.
     * Теперь у нас есть, что показать!
     * Мы можем написать, какую именно еду вывести на экран.
     */
    public void eat(String meat) {
        this.food = meat;
    }

    /**Создадим метод void show(), который будет выводить в консоль содержимое поля food.
     * Чтобы обратиться к полю объекта, нам нужно использовать ключевое слово this.
     * Это слово указывает, что нужно вывести содержимое поля.
     *
     * Как видишь, у переменной food нет значения, поэтому при выводе на консоль ты увидишь NULL.
     */
    public void show() {
        System.out.println("Kitty " + this.name + " eating " + this.food);
    }

    /**Содадим 2 объекта и вызовем у них метод show.
     * Но есть ли чего показывать? Нужно добавить непосредственно еду.
     * Обрати внимание, что сначала инциализируешь еду, а потом только показываешь.
     */
    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat gav = new Cat();
        System.out.println("There are gav's food.");
        gav.eat("Kotleta");
        gav.giveNick("Gav");
        gav.show();
        Cat black = new Cat();
        System.out.println("There are black's food.");
        black.giveNick("Black");
        black.eat("Fish");
        black.show();
    }

}

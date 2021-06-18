package ru.job4j.ooa;

/**
 * В методе main() создадим один объект при этом при объявлении добавим ключевое слово final,
 * после изменим внутренне состояние созданного объекта и
 * выведем в консоль объект до и после изменения
 */
public class Main {
    /**
     * Если мы объявляем константу на уровне класса,
     * то обычно пишут вот так FIRST_USER.
     */
    public static void main(String[] args) {
        final User FIRST_USER = new User("Consta", 15);
        System.out.println("Вывод в консоль до изменения.");
        System.out.println(FIRST_USER);
        System.out.println("Вывод в консоль после изменения.");
        FIRST_USER.setName("Petr");
        FIRST_USER.setAge(13);
        System.out.println(FIRST_USER);

        /**
         * Как мы видим - внутреннее состояние объекта поменялось. Однако вот такая запись:
         * FIRST_USER = new User("Stas", 9);   -   приводит к ошибке.
         */
    }
}

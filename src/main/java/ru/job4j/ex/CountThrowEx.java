package ru.job4j.ex;

/**
 * Данный класс показывает как кидать исключения и правильно их выбирать.
 * java.lang.IllegalArgumentException - метод вызывается
 * с некорректными параметрами.
 * java.lang.IllegalStateException - метод вызывается
 * с объекта в не корректном состоянии.
 * java.lang.NullPointerException - методы вызывается
 * у переменной, которая инициализирована null ссылкой.
 */
public class CountThrowEx {
    /**
     * Чтобы прервать выполнение программы, нужно использовать
     * оператор throw с передачей этому оператору объекта типа java.util.Exception.
     */
    public static int add(int start, int finish) {
        if (start > finish) {
            throw new IllegalArgumentException("Start should be less then finish.");
        }
        int rsl = 0;
        for (int index = start; index != finish; index++) {
            rsl += index;
        }
        return rsl;
    }

    /**
     * Если поменять местами числа в вызове метода, то цикл станет бесконечным,
     * а программа будет работать некорректно.
     * Нужно добавить проверку входных параметров и прервать выполнение
     * программы, если данные введены не верно.
     * Далее вносим правки в метод.
     */
    public static void main(String[] args) {
        System.out.println("Sum of 2 to 10 is: " + add(10, 2));
    }
}

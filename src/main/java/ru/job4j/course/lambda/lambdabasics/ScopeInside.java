package ru.job4j.course.lambda.lambdabasics;

import java.util.function.Supplier;

/**
 * 4. Зона видимости в лямбда-выражениях и исключения.
 * Данный класс описывает моменты, когда
 * переменная доступна и когда недоступна.
 */
public class ScopeInside {
    /**
     * Данный метод описывает несколько правил:
     * 1. Переменная, объявленная внутри
     * лямбда-выражения, доступна только
     * в самом лямбда-выражении.
     * 2. Переменная, объявленная вне лямбда-выражения,
     * доступна как внутри лямбда-выражения, так и вне его.
     * 3.Переменную, объявленную вне лямбда-выражения,
     * изменять внутри лямбда-выражения нельзя.
     * Этот пункт относится к строке:
     * {@code ayyyy = ayyyy + ", People."}
     * Строки закомментированы в учебных целях.
     * 4.В лямбда-выражениях нельзя использовать методы,
     * которые могут выбросить исключения.
     * Поток данных не может прерываться.
     * - А как быть?
     * - Не использовать лямбда-выражения с исключениями.
     * По задаче (сложить числа массива) нужно
     * исправить ошибку. Она заключается в том,
     * что переменная {@code total} меняется
     * внутри лямбда-выражения. Чтобы исправить,
     * необходимо создать копию переменной
     * {@code finalTotal} == самой переменной.
     * Об этом нам в лоб намекает сама IDE.
     */
    public static void main(String[] args) {
            String ayyyy = "ayyyyy";
            String name = echo(
                    () -> {
//                    String ayyyy = "ayyyyyyyy";
//                    ayyyy = ayyyy + ", People.";
                    return ayyyy;
                    }
            );
        System.out.println(name);
        System.out.println(ayyyy);

        int[] number = {1, 2, 3};
        int total = 0;
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            int finalTotal = total;
            total = add(
                    () -> finalTotal + num
            );
        }
        System.out.println(total);
    }

    public static String echo(Supplier<String> supplier) {
        String sound = supplier.get();
        return sound + " " + sound + " " + sound;
    }

    public static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}

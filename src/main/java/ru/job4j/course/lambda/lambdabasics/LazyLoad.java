package ru.job4j.course.lambda.lambdabasics;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2.3. Ленивая загрузка.
 * Данный класс описывает свойство лямбды -
 * отложенное выполнение.
 */
public class LazyLoad {
    /**
     * Данный метод описывает работу свойства.
     * 1.Если бы в нашем массиве было только 1 имя,
     * то отладочная информация "execute comparator"
     * не появится на экране, так как
     * лямбда вычисляется, когда вызывается метод
     * у функционального интерфейса. В нашем примере
     * это метод compare. И он не был вызван.
     * Сортировать нечего.
     * 2.Когда мы добавим в массив 2-е имя,
     * то метод ФИ будет вызван ->
     * будет произведена сортировка!
     */
    public static void main(String[] args) {

        String[] name = {
                "Ivan",
                "Petr",
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(name, lengthCmp);
    }
}

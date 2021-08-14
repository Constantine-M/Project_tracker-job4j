package ru.job4j.lambda.lambdabasics;

import ru.job4j.ex.CountThrowEx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 3. Ссылки на методы.
 * Данный класс описывает
 * одно упрощение связанное с лямбдами.
 * Заключается оно в использовании "двойного двоеточия" ::
 * и отсутствии аргументов в лямбде.
 * Если вся лямбда - это вызов другого метода,
 * то такой код можно упростить.
 */
public class RefMethod {
    /**
     * В данном методе показывается различие
     * между простой лямбдой и
     * ее упрощенной версией -
     * consumer и consRef.
     */
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
              "Ivan",
              "Petr",
              "Constantine",
              "PabloDiegoJoséFranciscodePaulaJuanNepomucenoPicasso",
              "Muckanaghederdauhaulia"
        );
        Consumer<String> consumer = (name) -> System.out.println(name);
        Consumer<String> consRef = System.out::println;
        names.forEach(consRef);

        Comparator<Integer> intCmp = (left, right) -> Integer.compare(left, right);
        Comparator<Integer> intCmpRef = Integer::compare;
        System.out.println("Cut these names out!");
        Consumer<String> out = RefMethod::cutOut;
        names.forEach(out);
    }

    public static void cutOut(String value) {
        if (value.length() > 10) {
            System.out.println(value.substring(0, 10));
        } else {
            System.out.println(value);
        }
    }
}

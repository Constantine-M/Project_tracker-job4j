package ru.job4j.course.function.strategypattern;


import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 1.3. Встроенные функциональные интерфейсы.
 * Данный класс описывает применение
 * функциональных интерфейсов в шаблонах проектирования.
 * В данном классе - это шаблон Стратегия.
 */
public class StrategyUsage {
    /**
     * Данный метод благодаря функциональному интерфейсу
     * Predicate становится универсальным.
     * Метод можно вызывать с разными экземплярами
     * Predicate.
     * @param pred предикат.
     * @param s строка, с которой будем работать.
     * @return true or false.
     */
    public boolean check(Predicate<String> pred, String s) {
        return pred.test(s);
    }

    /**
     * Данный метод позволяет выполнить
     * преобразования над строкой.
     * @param fun функциональный интерфейс Function.
     * @param s преобразуемая строка.
     * @return преобразованная строка.
     */
    public String transform(Function<String, String> fun, String s) {
        return fun.apply(s);
    }

    public static void main(String[] args) {
        StrategyUsage usage = new StrategyUsage();
        System.out.println("Результат работы: " + usage.check(
                str -> str.isEmpty(), ""));

        System.out.println("Результат работы: " + usage.check(
                str -> str.startsWith("Fun"), "Functional Interface"));

        System.out.println("Результат работы: " + usage.check(
                str -> str.contains("rn"), "Surname Name"));

        System.out.println("Строка после преобразования: "
                + usage.transform(
                        str -> str.toUpperCase(), "aBCdEfghKLmnpRstU"));

        System.out.println(
                usage.transform(
                        str -> str.concat("работает корректно"),
                        "Строка после преобразования: "));

        System.out.println("Строка после преобразования: "
                + usage.transform(
                        str -> str.trim(), "    aBC dEfghK Lmnp RstU        "));
    }
}

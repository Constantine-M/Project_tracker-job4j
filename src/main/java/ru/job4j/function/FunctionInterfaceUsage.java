package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionInterfaceUsage {
    /**
     * В данном методе пробежимся по
     * основным функциональным интерфейсам.
     * 1.Supplier (поставщик) используется для создания
     * какого-либо объекта и при этом ему
     * не требуется входной параметр.
     * 2.Consumer (потребитель) используется в том случае,
     * если нам нужно применить какое-то
     * действие или операцию к параметру
     * 3.
     */
    public static void main(String[] args) {
        Supplier<String> sup = () -> "New String For Interface";
        System.out.println(sup.get());

        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> sup1 = () -> new HashSet<>(list);
        Set<String> strings = sup1.get();
        for (String s : strings) {
            System.out.println(s);
        }

        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept(sup.get());
        BiConsumer<String, String> biConsumer = (s, s1) -> System.out.println(s + s1);
        biConsumer.accept(sup.get(), " and second String");

        List<String> list1 = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> sup2 = () -> new HashSet<>(list1);
        BiConsumer<Integer, String> secondConsumer = (s, s1) -> System.out.println(s + s1);
        Set<String> secondStrings = sup2.get();
        int i = 1;
        for (String s : secondStrings) {
            secondConsumer.accept(i++, " is " + s);
        }
    }
}

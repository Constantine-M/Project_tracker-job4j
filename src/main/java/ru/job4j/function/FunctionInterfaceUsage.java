package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {
    /**
     * В данном методе пробежимся по
     * основным функциональным интерфейсам.
     * 1.Supplier (поставщик) используется для создания
     * какого-либо объекта и при этом ему
     * не требуется входной параметр.
     * 2.Consumer (потребитель) используется в том случае,
     * если нам нужно применить какое-то
     * действие или операцию к параметру.
     * 3.Predicate (утверждение) наиболее часто
     * применяется в фильтрах и сравнении.
     * Возвращает логическое значение true или false.
     * 4.Function используется для преобразования входного
     * параметра или двух параметров в какое-либо значение.
     * Тип возвращаемого значения может
     * не совпадать с типом входных параметров.
     * 5.UnaryOperator и BinaryOperator – это разновидность Function,
     * в которых входные и выходные обобщенные
     * параметры должны совпадать.
     *
     */
    public static void main(String[] args) {
        Supplier<String> sup = () -> "New String For Interface";
        System.out.println(sup.get());

        List<String> list = List.of(
                "one", "two", "three", "one", "two", "three"
        );
        Supplier<Set<String>> sup1 = () -> new HashSet<>(list);
        Set<String> strings = sup1.get();
        for (String s : strings) {
            System.out.println(s);
        }

        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept(sup.get());
        BiConsumer<String, String> biConsumer =
                (s, s1) -> System.out.println(s + s1);
        biConsumer.accept(sup.get(), " and second String");

        List<String> list1 = List.of(
                "one", "two", "three", "one", "two", "three"
        );
        Supplier<Set<String>> sup2 = () -> new HashSet<>(list1);
        BiConsumer<Integer, String> secondConsumer =
                (s, s1) -> System.out.println(s + s1);
        Set<String> secondStrings = sup2.get();
        int l = 1;
        for (String s : secondStrings) {
            secondConsumer.accept(l++, " is " + s);
        }

        Predicate<String> pred = (s) -> s.isEmpty();
        System.out.println("Строка пустая: " + pred.test(""));
        System.out.println("Строка пустая: " + pred.test("test"));
        BiPredicate<String, Integer> cond = (s, i) -> s.contains(i.toString());
        System.out.println("Строка содержит подстроку: "
                + cond.test("Name123", 123));
        System.out.println("Строка содержит подстроку: "
                + cond.test("Name", 123));

        Function<String, Character> func = (s) -> s.charAt(2);
        System.out.println("Третий символ в строке: "
                + func.apply("first"));
        System.out.println("Третий символ в строке: "
                + func.apply("second"));
        BiFunction<String, Integer, String> bifunc = (s, i)
                -> s.concat(" ").concat(i.toString());
        System.out.println("Результат работы бифункции: "
                + bifunc.apply("Name", 123));
        System.out.println("Результат работы бифункции: "
                + bifunc.apply("String number", 12345));

        UnaryOperator<StringBuilder> builder = (s) -> s.reverse();
        System.out.println("Строка после реверса: "
                + builder.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: "
                + builder.apply(new StringBuilder("tset rof gnirtS")));
        BinaryOperator<StringBuilder> biBuilder =
                (b1, b2) -> b1.append(" ").append(b2);
        System.out.println(
                "Строка после объединения: " + biBuilder.apply(
                        new StringBuilder("First String"),
                        new StringBuilder("Second String")
                )
        );

    }
}

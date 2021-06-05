package ru.job4j.collection.sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        System.out.println("Интерфейс Comparable имеет всего один метод compareTo(T t).");
        Integer first = 1;
        Integer second = 2;
        int rsl = first.compareTo(second);
        System.out.println(rsl);
        System.out.println("Текущее значение - это объект у которого вызван метод compareTo." + System.lineSeparator()
                + "Метод compareTo вызван у объекта first, то есть текущее значение будет 1, " + System.lineSeparator() +
                "входящее значение будет 2. Результат вычисления метода будет меньше нуля. " + System.lineSeparator() +
                "Так как входящее значение больше, чем текущее.");
        System.out.println("Пример сравнения строк:");
        String petr = "Petr";
        String ivan = "Ivan";
        System.out.println(petr);
        System.out.println(ivan);
        int rslStr = petr.compareTo(ivan);
        System.out.println("При сравнении каждая строка раскладывается на массив символов, " + System.lineSeparator() +
                "которые в свою очередь преобразуются в массив чисел.");
        System.out.println("В этом примере, первое вычисление вернет число 7. " + System.lineSeparator() +
                "Так как 80 (буква Р) - 73(буква I) = 7. То есть больше нуля. " + System.lineSeparator() +
                "Это значит, что слово \"Petr\" больше, чем слово \"Ivan\".");
        System.out.println();
        System.out.println("Сортировка по убыванию. По умолчанию доступен только один порядок сортировки." + System.lineSeparator() +
                "Чтобы сделать другой порядок, в Java есть интерфейс java.util.Comparator.");
        List<Integer> list2 = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list2);
        System.out.println("В метод sort с коллекцией передается объект Comparator.");
        Collections.sort(list2, Collections.reverseOrder());
        System.out.println(list2);
    }
}

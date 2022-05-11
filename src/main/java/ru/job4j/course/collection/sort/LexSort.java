package ru.job4j.course.collection.sort;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    /**
     * В данном методе мы предусматриваем, что в строке будут прописываться пункты,
     * которые нам нужно будет сравнить. Иначе сравнение таких строк пойдет по алфавиту.
     * Пример: 1. Первый пункт.
     * Сначала разделяем строку на "номер пункта" и его название.
     * Затем представляем строку в виде числа. Далее сравниваем их.
     * Чтобы уметь делить строки, стоит почитать про регулярные выражения.
     * @param left первая строка.
     * @param right вторая строка.
     * @return 0, 1 или -1.
     */
    @Override
    public int compare(String left, String right) {
        String[] first = left.split("[.]", 2);
        String[] second = right.split("[.]", 2);
        int a = Integer.parseInt(first[0]);
        int b = Integer.parseInt(second[0]);
        return Integer.compare(a, b);
    }
}

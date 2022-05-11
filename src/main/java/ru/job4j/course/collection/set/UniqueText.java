package ru.job4j.course.collection.set;

import java.util.HashSet;

/**
 * 2. Идентичные тексты.
 * Данный класс позволяет проверить текст на уникальность.
 */
public class UniqueText {
    /**
     * 1. Преобразовать строку в массив слов. Для этого используется метод String.split(" ").
     * 2. Массив строк вставить через цикл for-each в коллекцию HashSet.
     * 3. Преобразовать проверяемый текст в массив слов по аналогии с пунктом 1.
     * 4. Проверить массив строк через цикл for-each в коллекции HashSet используя метод contains.
     * Метод contains в HashSet работает за константное время.
     * То есть не зависимо от количества элементов в коллекции.
     * ВОСКЛИЦАТЕЛЬНЫЙ ЗНАК может менять всю суть. С ним у тебя будет такая формулировка -
     * все ли слова существуют в оригинальной строке?
     * Без знака "!" будет так - ЕСЛИ ХОТЯ БЫ ОДНО СЛОВО СОВПАДАЕТ...
     * @param originText оригинальный текст
     * @param dublicateText вероятный дубликат
     * @return ИСТИНА, если тексты одинаковые, иначе ЛОЖЬ
     */
    public static boolean isEquals(String originText, String dublicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = dublicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String original : origin) {
            check.add(original);
        }
        for (String dublicate : text) {
            if (!check.contains(dublicate)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}

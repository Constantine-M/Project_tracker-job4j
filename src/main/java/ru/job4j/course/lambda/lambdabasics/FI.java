package ru.job4j.course.lambda.lambdabasics;

import ru.job4j.course.lambda.Attachment;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2.1. Лямбда.
 * Данный класс описывает наглядно термин "лямбда".
 * В программировании термин лямбда обозначает
 * возможность передать в качестве параметра
 * блок кода. Переданный блок кода может быть
 * вызван в любой момент времени или не вызван вообще.
 */
public class FI {
    /**
     * Данный метод показывает наглядно
     * эффективность использования лямбды.
     * Закомментированный код можно
     * сильно сократить, используя лямбду.
     * Ну и сделает код красивше).
     * В одном из примеров необходимо
     * отсортировать названия задач по номеру.
     * А эти номера внутри строки.
     * Ранее решали через {@code split},
     * а теперь можно через {@code substring}.
     */
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> {
            System.out.println("compare - " + left.getSize() + " : " + right.getSize());
            return left.getSize() - right.getSize();
        };

                /*new Comparator<Attachment>() {
                    @Override
                    public int compare(Attachment left, Attachment right) {
                        return left.getSize() - right.getSize();
                    }
        };*/
        Comparator<String> cmpSize = (left, right) ->
                Integer.compare(left.length(), right.length());
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Comparator<String> cmpDescSize = (left, right) ->
                Integer.compare(right.length(), left.length());
        Arrays.sort(atts, comparator);

        String[] numbers = {
                "1. Task",
                "2. Task",
                "11. Task"
        };
        Comparator<String> numStr = (left, right) -> {
            int first = Integer.valueOf(left.substring(0, left.indexOf(".")));
            int second = Integer.valueOf(right.substring(0, right.indexOf(".")));
            return first - second;
        };
    }
}

package ru.job4j.course.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1.1. Анонимные классы.
 * Мы знаем, что в проекте есть только один случай, где
 * нужно использовать этот компаратор. Чтобы не
 * засорять папки проекта лишними файлами, в Java
 * добавили возможность создать объект
 * на основании анонимного класса. Он внутри.
 * Обратите внимание, что после имени интерфейса мы
 * указываем фигурные скобки. Внутри фигурных скобок
 * содержится тело нового класса (методы, поля).
 * В нем же мы и определяем недостающие методы.
 * Обобщенные типы в анонимных классах,
 * например "Attachment" желательно всегда
 * указывать.
 */
public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("Image 1", 100),
                new Attachment("Image 2", 34),
                new Attachment("Image 3", 13)
        );

        Comparator comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getSize() - right.getSize();
            }
        };

        attachments.sort(comparator);
        System.out.println(attachments);

        Comparator attachNameComp = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getName().compareTo(right.getName());
            }
        };

        System.out.println("Sorting by name: ");
        attachments.sort(attachNameComp);
        System.out.println(attachments);

        ArrayList list = new ArrayList<Integer>() {
            @Override
            public boolean add(Integer o) {
                System.out.println("Add a new element to list: " + o);
                return super.add(0);
            }
        };

        list.add(100500);
    }
}

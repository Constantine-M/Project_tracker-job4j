package ru.job4j.lambda;

import java.util.Comparator;

/**
 * 1.1. Анонимные классы.
 * Создали компаратор в виде отдельного класса
 * для сравнения с анонимным в классе AttachmentSort.
 * Как видишь, они почти идентичны.
 * Но в анонимном классе нет имени класса.
 */
public class AttachmentComp implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Attachment left = (Attachment) o1;
        Attachment right = (Attachment) o2;
        return left.getSize() - right.getSize();
    }
}

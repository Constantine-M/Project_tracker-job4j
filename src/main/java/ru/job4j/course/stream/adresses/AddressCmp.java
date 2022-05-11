package ru.job4j.course.stream.adresses;

import java.util.Comparator;

/**
 * 3. Уникальность элементов и сортировка.
 * Данный класс сортирует адреса по
 * названию города в порядке возрастания.
 */
public class AddressCmp implements Comparator<Address> {

    /**
     * Данный метод сравнивает наименования
     * городов, независимо от того,
     * с заглавной буквы Вы написали город
     * или сделали ошибку.
     * Это можно сделать благодаря методу
     * {@code toUpperCase()}.
     * Данный компаратор помогает ТОЛЬКО СОРТИРОВАТЬ.
     * @param o1 имя первого города.
     * @param o2 имя второго города.
     */
    @Override
    public int compare(Address o1, Address o2) {
        return o1.getCity().toUpperCase().compareTo(o2.getCity().toUpperCase());
    }
}

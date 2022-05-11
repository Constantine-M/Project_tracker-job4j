package ru.job4j.course.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Паспорт и жители.
 */
public class PassportOffice {
    /**
     * Обьявляем коллекцию Map, в которой ключом будет объект класса String (это
     * есть наш паспорт), а значением объект класса Citizen (все данные гражданина целиком).
     */
    private Map<String, Citizen> citizens = new HashMap<>();

    /**
     * Данный метод проверяет, если гражданина нет в списке, то
     * добавляем в список с ключом, который соответствует паспорту и
     * значением = объекту класса Citizen.
     * @param citizen гражданин (паспорт, ФИО).
     * @return TRUE если его нет в списке.
     */
    public boolean add(Citizen citizen) {
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            return true;
        }
        return false;
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}

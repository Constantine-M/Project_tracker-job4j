package ru.job4j.function.strategypattern;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 1.3. Встроенные функциональные интерфейсы.
 * Данный класс описывает фильтр папок.
 * Здесь мы будем использовать интерфейс
 * Predicate, метод будет универсальный.
 */
public class SearchFolder {
    /**
     * Данный метод описывает фильтр папок.
     * Он универсальный. Благодаря функциональному
     * интерфйсу Predicate можно у объекта f
     * вызвать любой его метод.
     * В нашем случае это getSize и getName.
     * Если то, что мы опишем в лямбда выражении
     * (условие), выполняется, то объект
     * добавляется в результирующий список.
     * @param list список папок на входе
     * @param pred функциональный интерфейс
     * @return новый отфильтрованный
     *         список папок
     */
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder f  : list) {
            if (pred.test(f)) {
                rsl.add(f);
            }
        }
        return rsl;
    }
}

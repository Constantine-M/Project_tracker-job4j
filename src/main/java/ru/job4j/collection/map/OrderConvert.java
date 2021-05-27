package ru.job4j.collection.map;

import java.util.HashMap;
import java.util.List;

/**
 * 2. Преобразования List в Map.
 */
public class OrderConvert {
    /**
     * Данный метод преобразовывает List в Map.
     * Ключом в Map будет номер заказа (number).
     * @param orders заказы - объекты класса Order.
     * @return Map, где ключ - это номер, а значение - сам заказ.
     */
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order s : orders) {
            map.put(s.getNumber(), s);
        }
        return map;
    }
}

package ru.job4j.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 0. Map, HashMap.
 */
public class UsageMap {
    /**
     * Часто возникает ситуация, когда нам нужно хранить не плоскую модель, а пары ключ-значение.
     * Кто-то возразит, мы можем создать модель Pair(key, value) и хранить данные в ArrayList.
     * Другое решение - это использование ассоциативных карт или справочников.
     * 1.Вставка - метод PUT.
     * Здесь мы видим, в карту мы добавляем сразу два аргумента,
     * то есть делаем ассоциацию ключа с его значением.
     * 2.Вывод на печать и терация - с помощью for-each.
     * В интерфейсе java.util.Map есть методы keySet(),
     * который возвращает коллекцию java.util.Set состоящую только из ключей.
     * Через метод GET мы получаем значение ассоциированное с этим ключом.
     * Другой способ получить все значения - это использовать метод entrySet(). 
     * Этот метод вернет коллекцию java.util.Set состоящую из объекта Map.Entry, 
     * которая сразу содержит и ключ и значение.
     * 3.Обновление пары - тот же метод PUT.
     * Ключ пары должен быть уникальный.
     * Если в Map уже есть такой key, то ячейка value будет заменена на новое значение.
     * В примере ниже размер Map будет 1, а не 2, потому что вторая пара имеет ключ,
     * который уже был в Map. Ключ - это почта "consta@mail.ru".
     * !!!!!!!!!!!!!!!!Проверка ключей происходит по методу equals!!!!!!!!!!!!!!!!
     * 4.Удаление - метод remove(key) - удаление происходит по ключу.
     *
     */
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("consta@mail.ru", "Consta Mezenin");
        map.put("consta@mail.ru", "Constantine Mezenin");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
        System.out.println("Use the entrySet()");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
        map.remove("consta@mail.ru");
        System.out.println("А теперь к задаче...");
        map.put("mez36@mail.ru", "Constantine Mezenin Arkadevich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}

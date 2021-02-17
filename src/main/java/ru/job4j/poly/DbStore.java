package ru.job4j.poly;

/**
 * Создали класс-хранилище.
 * Там мы храним инфомрацию и загружаем.
 * После того как мы создали интерфейс, мы применили его к хранилищам.
 * Добавилось: public cl.... implements Store.
 * Теперь хранилища не привязаны друг к другу (наследование не нужно уже).
 */
public class DbStore implements Store {
    public void save(String value) {

    }

    public String[] load() {
        return new String[] {};
    }
}

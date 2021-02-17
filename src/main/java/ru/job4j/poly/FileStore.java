package ru.job4j.poly;

/**
 * Создали класс-наследник.
 * После того как мы создали интерфейс, мы применили его к хранилищам.
 * Удалили: public cl..... extends DbStore / super.. тоже лишнее теперь
 * Добавилось: public cl.... implements Store.
 * Теперь хранилища не привязаны друг к другу (наследование не нужно уже).
 */
public class FileStore implements Store {
    @Override
    public void save(String value) {
    }

    @Override
    public String[] load() {
        return new String[0];
    }
}

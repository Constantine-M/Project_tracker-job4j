package ru.job4j.collection.map.bank;

import java.util.Objects;

/**
 * 3. Банковские переводы.
 * Данный класс описывает пользователя банка.
 * @author Constantine
 * @version 1.0
 */
public class User {

    /**
     * Данное поле описывает паспортные данные
     * пользователя - серия/номер к примеру.
     */
    private String passport;

    /**
     * Данное поле описывает имя пользователя - ФИО.
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * @return возвращает паспортные данные -
     * серия/номер например.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Данный метод изменяет паспортные данные.
     * @param passport паспортные данные -
     *        серия/номер например.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * @return возвращает имя пользователя.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Данный метод изменяет имя пользователя.
     * @param username имя пользователя.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Данный метод переопределяет метод {@link Object#equals(Object)}
     * @param o объект класса {@link #User(String, String)}
     * @return возвращает {@code true} если объекты равны,
     * иначе {@code false}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Данный метод переопределяет метод {@link Object#hashCode()}
     * @return возвращает хэш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}

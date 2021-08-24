package ru.job4j.collection.map.bank;

import java.util.Objects;

/**
 * 3. Банковские переводы.
 * 6. Тестовое задание из модуля коллекции
 * Lite переделать на Stream API.
 * Данный класс описывает бансковский счет пользователя.
 * @author Constantine
 * @version 1.0
 */
public class Account {
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * @return возвращает реквизиты пользователя.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Данный метод изменяет реквизиты пользователя.
     * @param requisite реквизиты пользователя.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * @return возвращает баланс счета пользователя.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Данный метод изменяет баланс счета пользователя.
     * @param balance баланс счета пользователя.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Данный метод переопределяет метод {@link Object#equals(Object)}
     * @param o объект класса {@link #Account(String, double)}
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Данный метод переопределяет метод {@link Object#hashCode()}
     * @return возвращает хэш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}

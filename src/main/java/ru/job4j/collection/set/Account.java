package ru.job4j.collection.set;

import java.util.Objects;

/**
 * 3. Модели данных и HashSet.
 * Данный класс описывает клиента банка.
 */
public class Account {
    private String passport;
    private String username;
    private String deposit;

    /**
     * Переопределили метод equals. Сранивать объекты будем по полю "passport".
     * @param o объекта класса Account.
     * @return TRUE, if objects are equals. Else FALSE.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(passport, account.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public String toString() {
        return "Account{" +
                "passport='" + passport + '\'' +
                ", username='" + username + '\'' +
                ", deposit='" + deposit + '\'' +
                '}';
    }

    public Account(String passport, String username, String deposit) {
        this.passport = passport;
        this.username = username;
        this.deposit = deposit;
    }
}

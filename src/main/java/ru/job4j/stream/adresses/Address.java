package ru.job4j.stream.adresses;

import java.util.Objects;

/**
 * 2. Список адресов.
 * Данный класс описывает адрес клиента.
 * Если здесь не переопределить quals,
 * то программа не заработает.
 * Реализация по умолчанию метода equals() в
 * классе {@see java.lang.Object} сравнивает ссылки
 * на адреса в памяти, которые хранят
 * переменные, и возвращает true только в
 * том случае, если адреса совпадают,
 * другими словами переменные ссылаются
 * на один и тот же объект.
 * Методы {@code get} здесь не нужны,
 * т.к. в классе {@link Profile}
 * мы возвращаем весь объект Address.
 */
public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }
}

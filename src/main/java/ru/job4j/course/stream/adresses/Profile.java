package ru.job4j.course.stream.adresses;

/**
 * 2. Список адресов.
 * Данный класс описывает анкету.
 * Анкета - модель.
 */
public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}

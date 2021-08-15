package ru.job4j.collection.search;

/**
 * 6. Функции высшего порядка.
 * В данном классе опишем пользователя,
 * у которого есть имя, фамилия, номер телефона и адрес.
 */
public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}

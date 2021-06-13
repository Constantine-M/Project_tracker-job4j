package ru.job4j.collection.sort;


import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * 1. Организовать сортировку User.
 */
public class User implements Comparable<User> {
        private String name;
        private int age;

    /**
     * Знак " :: " появился в Java 8 и он обозначает, в случае
     * с методом compareTo, ссылку на метод getName класса User.
     * В данном методе мы сначала сравниваем имена.
     * Если имена одинаковые, то начинаем сравнивать возраст.
     * И в конце с помощью метода " .compare " мы указываем 2х пользователей -
     * текущего и того, кого передали в метод.
     * Не путай методы интерфейсов. У интерфейса Comparable только метод " compareTo ",
     * а у интерфейса Comparator метод " compare " и другие.
     * Поэтому мы в этом методе, возвращая компаратор, использовали
     * метод " compare ".
     * Приведенный ниже метод классный, но по задаче все делаем через Comparable.
     * public int compareTo(User user) {
     *   return Comparator.comparing(User::getName).thenComparing(User::getAge).compare(this, user);
     }*/
    @Override
    public int compareTo(User anotherUser) {
        int compareName = name.compareTo(anotherUser.name);
        if (compareName == 0) {
            return Integer.compare(age, anotherUser.age);
        }
        return compareName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

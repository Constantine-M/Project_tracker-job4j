package ru.job4j.ooa;

/**
 * Важно подчеркнуть важную особенность поведения ключевого слова final
 * для ссылочных типов данных - после присвоения объекта, нельзя изменить
 * ссылку на данный объект. Однако при этом мы можем изменить внутреннее состояние объекта.
 * Пример рассмотрим ниже. Добавим User с 2 полями.
 */
public class User {
    private String name;

    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age
                + '}';
    }
}

package ru.job4j.collection.search;

import java.util.ArrayList;

/**
 * Составим модель справочника.
 */
public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    /**
     * В данном методе мы уже добавляем пользователя, используя методы класса ArrayList.
     * @param person пользователь, которого хотим добавить в список (в телефонную книгу).
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     * Здесь есть паразитная конструкция. Я о ней помню, но с помощью try-catch не получается.
     * Можно еще вернуть null и не использовать исключения.
     */
    public ArrayList<Person> find(String key) throws NotFoundException {
        ArrayList<Person> result = new ArrayList<>();
        for (Person client : persons) {
            if (client.getName().contains(key) || client.getSurname().contains(key)
                    || client.getPhone().contains(key) || client.getPhone().contains(key)) {
                result.add(client);
            } else {
                throw new NotFoundException("Person not found");
            }
        }
        return result;
    }
}

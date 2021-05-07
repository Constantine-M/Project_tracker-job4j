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
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person list : persons) {
            if (list.getName().contains(key) || list.getSurname().contains(key)
                    || list.getPhone().contains(key) || list.getPhone().contains(key)) {
                result.add(list);
            }
        }
        return result;
    }
}

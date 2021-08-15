package ru.job4j.collection.search;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * 6. Функции высшего порядка.
 * Составим модель справочника.
 */
public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    /**
     * В данном методе мы уже добавляем пользователя,
     * используя методы класса ArrayList.
     * @param person пользователь, которого хотим
     *               добавить в список (в телефонную книгу).
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей,
     * который содержат key в любых полях.
     * В учебных целях оставлю старый блок кода.
     * В данном методе мы блок с условиями
     * заменили на функцию высшего порядка.
     * @param key Ключ поиска.
     * @return Список подошедших пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> namePred = (Person user)
                -> user.getName().contains(key);
        Predicate<Person> surnamePred = (Person user)
                -> user.getSurname().contains(key);
        Predicate<Person> phonePred = (Person user)
                -> user.getPhone().contains(key);
        Predicate<Person> addressPred = (Person user)
                -> user.getAddress().contains(key);
        Predicate<Person> combine = namePred.or(surnamePred).or(phonePred).or(addressPred);
        for (Person client : persons) {
            if (combine.test(client)) {
                result.add(client);
            }
//            if (client.getName().contains(key) || client.getSurname().contains(key)
//                    || client.getPhone().contains(key) || client.getAddress().contains(key)) {
//                result.add(client);
//            }
        }
        return result;
    }
}

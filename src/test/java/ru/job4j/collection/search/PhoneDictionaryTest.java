package ru.job4j.collection.search;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;

public class PhoneDictionaryTest {
    /**
     * В тесте мы создаем объект класса PhoneDictionary (список номеров в тел. книге),
     * который содержит список (ArrayList) с ФИО, номером и адресом пользователя.
     * Так как нам необходимо вернуть список, то в кач-ве результата объявляем список persons
     * и находим запись, в которой одно из полей соответствует КЛЮЧУ.
     * А чтобы сравнить, мы используем get-еры.
     */
    @Test
    public void whenFindPersonByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Const", "Mezenin", "8752", "VTagil")
        );
        String key = "Con";
        ArrayList<Person> persons = phones.find(key);
        assertThat(persons.get(0).getName(), is("Const"));
    }

    /**
     * Чтобы проверить, что мы ничего не нашли, нужно в тесте показать,
     * что результирующая коллекция ПУСТАЯ. И всё).
     */
    @Test
    public void whenNotFindPersonThenEmpty() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Const", "Mezenin", "8752", "VTagil")
        );
        String key = "123";
        ArrayList<Person> persons = phones.find(key);
        Assert.assertTrue(persons.isEmpty());
    }
}
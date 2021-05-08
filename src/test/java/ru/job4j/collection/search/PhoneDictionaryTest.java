package ru.job4j.collection.search;

import org.hamcrest.Matcher;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
    public void whenFindPersonByName() throws NotFoundException {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Const", "Mezenin", "8752", "VTagil")
        );
        String key = "Con";
        ArrayList<Person> persons = phones.find(key);
        assertThat(persons.get(0).getName(), is("Const"));
    }
    /**
    @Test
    public void whenNotFindPerson() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Const", "Mezenin", "8752", "VTagil")
        );
        String key = "123";
        ArrayList<Person> persons = phones.find(key);
        assertThat(persons, is(nullValue()));
    }*/

    /**
     * Используется паразитная конструкция if-else-throw!!!
     */
    @Test(expected = NotFoundException.class)
    public void whenNotFindPersonThenEx() throws NotFoundException {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Const", "Mezenin", "8752", "VTagil")
        );
        String key = "123";
        ArrayList<Person> persons = phones.find(key);
    }


}
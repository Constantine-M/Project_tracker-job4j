package ru.job4j.course.collection.set;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NotifyAccountTest {

    /**
     * Мы не создаем объекты класса Account по отдельности!
     * Мы создаем СПИСОК учетных записей. Этот же список будет отправлен в метод sent.
     * Метод Arrays.asList позволяет представить массив в виде списка. Это удобно
     * во время тестирования.
     */
    @Test
    public void whenDeleteDublicate() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Consta", "1000"),
                new Account("123", "ConstaM", "1000000"),
                new Account("456", "Batman", "99999999999")
        );
        HashSet<Account> expected = new HashSet<>(Set.of(
                new Account("123", "Consta", "1000"),
                new Account("456", "Batman", "99999999999")
        ));
        assertThat(NotifyAccount.sent(accounts), is(expected));
    }

    @Test
    public void whenBothAccountUnique() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Set.of(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}
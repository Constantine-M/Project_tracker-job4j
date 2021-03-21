package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FactTest {
    /**
     * Данный тест делает проверку на исключение.
     * Тест будет прерываться, т.к. мы в аннотации указали,
     * что ожидаем прерывание.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenNLessThen0() {
        Fact.calc(-5);
    }

    /**
     * Тест ниже делает проверку метода.
     */
    @Test
    public void when3Then6() {
        int rsl = Fact.calc(3);
        assertThat(rsl, is(6));
    }
}
package ru.job4j.course.collection.set;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UniqueTextTest {
    /**
     * В данном тесте метод обращает внимание на запятые.
     * Это было любопытно. К этому я шел 2 часа((.
     */
    @Test
    public void whenTextsAreNotEqualsBecauseOfComma() {
        String origin = "Harry, you are";
        String dublicate = "are you Harry";
        assertThat(UniqueText.isEquals(origin, dublicate), is(false));
    }

    /**
     * А еще метод регистрозависимый. К этому я тоже долго шел.
     */
    @Test
    public void whenTextsAreEquals() {
        String origin = "Harry you are a wizard";
        String dublicate = "a wizard are you Harry";
        assertThat(UniqueText.isEquals(origin, dublicate), is(true));
    }

    @Test
    public void whenTextsAreNotEquals() {
        String origin = "My cat eats a mouse";
        String dublicate = "A mouse is eaten by a cat";
        assertThat(UniqueText.isEquals(origin, dublicate), is(false));
    }
}
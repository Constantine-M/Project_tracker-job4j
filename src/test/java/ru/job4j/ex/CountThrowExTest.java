package ru.job4j.ex;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CountThrowExTest {
    /**
     * Если нам нужно проверить ситуацию, когда программа прерывается
     * с исключением нам нужно в аннотации @Test указать класс исключения.
     * Операторов сравнения assertThat в этом тесте нет,
     * потому что программа просто не дойдет до выполнения этих операторов.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenStartGreaterThenFinish() {
        CountThrowEx.add(10, 2);
    }

    /**
     * Ранее в аннотации мы также оставляли параметр expected = IllegalArgumentException.class,
     * и во время проверки тест упал, т.к. ожидал прерывания теста из-за исключения.
     */
    @Test
    public void when0To3Then3() {
        int rsl = CountThrowEx.add(0, 3);
        assertThat(rsl, is(3));
    }
}
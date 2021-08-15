package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FindFuncTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FindFunc.diapason(5, 8, (x) -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D, 17D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenMineLinearFunctionThenMineLinearResults() {
        List<Double> result = FindFunc.diapason(1, 10, x -> x);
        List<Double> expected = Arrays.asList(1D, 2D, 3D, 4D, 5D, 6D, 7D, 8D, 9D, 10D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = FindFunc.diapason(1, 5, x -> x * x + 3);
        List<Double> expected = Arrays.asList(4D, 7D, 12D, 19D, 28D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResult() {
        List<Double> result = FindFunc.diapason(1, 5, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(2D, 4D, 8D, 16D, 32D);
        assertThat(result, is(expected));
    }
}
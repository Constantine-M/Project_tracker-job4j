package ru.job4j.stream.flatmap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 5. Преобразование матрицы чисел в список чисел.
 */
public class UsageFlatMapTest {

    @Test
    public void whenMatrixThenList() {
        UsageFlatMap toList = new UsageFlatMap();
        Integer[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        List<Integer> result = toList.convert(matrix);
        List<Integer> expected = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,15, 16);
        assertThat(result, is(expected));
    }

    /**
     * Тут я вспомнил, что ArrayList
     * может содержать в себе null.
     */
    @Test
    public void whenMatrixThenListWithNull() {
        UsageFlatMap toList = new UsageFlatMap();
        Integer[][] matrix = {
                {1, 2, null, 4},
                {5, 6, 7, 8}
        };
        List<Integer> result = toList.convert(matrix);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(null);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        assertThat(result, is(expected));
    }
}
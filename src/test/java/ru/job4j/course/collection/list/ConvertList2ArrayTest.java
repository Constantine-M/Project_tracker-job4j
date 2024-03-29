package ru.job4j.course.collection.list;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConvertList2ArrayTest {

    @Test
    public void when7ElementsThen9InArray() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7), 3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when2ElementsThen4InArray() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                List.of(1, 2, 3), 2
        );
        int[][] expect = {
                {1, 2},
                {3, 0},
        };
        assertThat(result, is(expect));
    }
}
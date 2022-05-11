package ru.job4j.course.collection.list;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.List;

public class ConvertMatrix2ListTest {

    @Test
    public void whenCells3ThenListOf9Elements() {
        ConvertMatrix2List array = new ConvertMatrix2List();
        List<Integer> result = array.toList(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(result, is(expected));
    }

    @Test
    public void whenCells2ThenListOf4Elements() {
        ConvertMatrix2List array = new ConvertMatrix2List();
        List<Integer> result = array.toList(new int[][]{
                {1, 2},
                {3, 4},
        });
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(result, is(expected));
    }
}
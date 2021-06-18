package ru.job4j.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConvertListTest {
    /**
     * Чтобы создать список массивов, нужно сначала создать список.
     * А затем добавлять в него массивы. По-другому у
     * меня не получалось..поэтому я подглядывал в каркас.
     */
    @Test
    public void whenListOf2ArraysThenConvertToListOfNineEl() {
        List<int[]> input = new ArrayList<>();
        input.add(new int[] {1, 2, 3});
        input.add(new int[] {4, 5, 6});
        input.add(new int[] {7, 8, 9});
        List<Integer> result = ConvertList.convert(input);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(result, is(expected));
    }

    @Test
    public void whenListOf2ArraysThenConvertToListOfFourEl() {
        List<int[]> input = new ArrayList<>();
        input.add(new int[] {1});
        input.add(new int[] {2, 3, 4});
        List<Integer> result = ConvertList.convert(input);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertThat(result, is(expected));
    }
}
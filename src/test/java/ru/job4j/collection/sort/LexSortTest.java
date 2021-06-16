package ru.job4j.collection.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LexSortTest {
    @Test
    public void whenSortNum1And2And10() {
        List<String> input = Arrays.asList(
                  "10. Task.",
                  "1. Task.",
                  "2. Task."
        );
        List<String> out = Arrays.asList(
                "1. Task.",
                "2. Task.",
                "10. Task."
        );
        Collections.sort(input, new LexSort());
        assertThat(input, is(out));
    }

}
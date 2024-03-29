package ru.job4j.course.collection.departments;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DepartmentsTest {

    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> rsl = Departments.fillGaps(input);
        assertThat(rsl, is(expect));
    }

    @Test
    public void whenManyMissed() {
        List<String> input = List.of("k1/sk1/ssk1/skk1");
        List<String> expect = List.of("k1", "k1/sk1", "k1/sk1/ssk1", "k1/sk1/ssk1/skk1");
        List<String> rsl = Departments.fillGaps(input);
        assertThat(rsl, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = List.of("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> rsl = Departments.fillGaps(input);
        assertThat(rsl, is(expect));
    }

    @Test
    public void whenManyListsAndManyMissed() {
        List<String> input = List.of("k1/sk1", "k1/sk1/ssk1", "k1/sk1/ssk2", "k1/sk2",
                "k2", "k2/sk1/ssk1", "k2/sk1/ssk2");
        List<String> expect = List.of("k2", "k2/sk1", "k2/sk1/ssk1", "k2/sk1/ssk2",
                "k1", "k1/sk1", "k1/sk1/ssk1", "k1/sk1/ssk2", "k1/sk2");
        List<String> rsl = Departments.fillGaps(input);
        rsl.sort(new DepDescComp());
        assertThat(rsl, is(expect));
    }
}
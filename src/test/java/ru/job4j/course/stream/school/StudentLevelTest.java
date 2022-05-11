package ru.job4j.course.stream.school;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Student> input = new ArrayList<>();
                input.add(new Student(30, "Ezra Bridger"));
                input.add(new Student(120, "Eno Cordova"));
                input.add(null);
                input.add(new Student(80, "Cal Kestis"));
                input.add(null);
                input.add(new Student(115, "Cere Junda"));
        List<Student> expected = List.of(
                new Student(120, "Eno Cordova"),
                new Student(115, "Cere Junda")
        );
        List<Student> result = StudentLevel.levelOf(input, 80);
        assertThat(result, is(expected));
    }

    @Test
    public void whenOnlyNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        List<Student> expected = List.of();
        assertThat(StudentLevel.levelOf(input, 100), is(expected));
    }

    @Test
    public void whenHasNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        input.add(new Student(28, "Pety"));
        List<Student> expected = List.of(new Student(28, "Pety"));
        assertThat(StudentLevel.levelOf(input, 10), is(expected));
    }
}
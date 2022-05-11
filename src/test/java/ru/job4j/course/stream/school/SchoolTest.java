package ru.job4j.course.stream.school;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SchoolTest {

    @Test
    public void whenCollectClassA() {
        List<Student> students = List.of(
                new Student(70, "Smith"),
                new Student(89, "Jonson"),
                new Student(95, "Winch"),
                new Student(10, "Malfoy"),
                new Student(30, "Polkiss"),
                new Student(50, "Dursley"),
                new Student(69, "Gordon"),
                new Student(49, "Jackson"),
                new Student(0, "Lestrange"),
                new Student(63, "Mezenin")
        );
        Predicate<Student> predict =
                student -> student.getScore() >= 70
                && student.getScore() <= 100;
        School school = new School();
        List<Student> rsl = school.collect(students, predict);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(70, "Smith"));
        expected.add(new Student(89, "Jonson"));
        expected.add(new Student(95, "Winch"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        List<Student> students = List.of(
                new Student(70, "Smith"),
                new Student(89, "Jonson"),
                new Student(95, "Winch"),
                new Student(10, "Malfoy"),
                new Student(30, "Polkiss"),
                new Student(50, "Dursley"),
                new Student(69, "Gordon"),
                new Student(49, "Jackson"),
                new Student(0, "Lestrange"),
                new Student(63, "Mezenin")
        );
        Predicate<Student> predict =
                student -> student.getScore() >= 50
                        && student.getScore() < 70;
        School school = new School();
        List<Student> rsl = school.collect(students, predict);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50, "Dursley"));
        expected.add(new Student(69, "Gordon"));
        expected.add(new Student(63, "Mezenin"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassV() {
        List<Student> students = List.of(
                new Student(70, "Smith"),
                new Student(89, "Jonson"),
                new Student(95, "Winch"),
                new Student(10, "Malfoy"),
                new Student(30, "Polkiss"),
                new Student(50, "Dursley"),
                new Student(69, "Gordon"),
                new Student(49, "Jackson"),
                new Student(0, "Lestrange"),
                new Student(63, "Mezenin")
        );
        Predicate<Student> predict =
                student -> student.getScore() > 0
                        && student.getScore() < 50;
        School school = new School();
        List<Student> rsl = school.collect(students, predict);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(10, "Malfoy"));
        expected.add(new Student(30, "Polkiss"));
        expected.add(new Student(49, "Jackson"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassToMap() {
        List<Student> students = List.of(
                new Student(23, "Skywalker"),
                new Student(49, "Organa"),
                new Student(23, "Skywalker"),
                new Student(11, "Solo"),
                new Student(96, "Lars"),
                new Student(29, "Sifo-Dyas"),
                new Student(77, "Kenobi"),
                new Student(11, "Solo"),
                new Student(89, "Windu"),
                new Student(66, "Bane"),
                new Student(99, "Palpatine")
        );
        School school = new School();
        Map<String, Student> result = school.collectToMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Skywalker", new Student(23, "Skywalker"));
        expected.put("Organa", new Student(49, "Organa"));
        expected.put("Solo", new Student(11, "Solo"));
        expected.put("Lars", new Student(96, "Lars"));
        expected.put("Sifo-Dyas", new Student(29, "Sifo-Dyas"));
        expected.put("Kenobi", new Student(77, "Kenobi"));
        expected.put("Windu", new Student(89, "Windu"));
        expected.put("Bane", new Student(66, "Bane"));
        expected.put("Palpatine", new Student(99, "Palpatine"));
        assertThat(result, is(expected));
    }
}
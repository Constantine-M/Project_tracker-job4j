package ru.job4j.stream.school;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.*;

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
}
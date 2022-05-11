package ru.job4j.course.stream.college;

import org.junit.Test;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CollegeTest {

    @Test
    public void whenAccountIsOptionalEmpty() {
        Map<Student, Set<Subject>> students = Map.of(
                new Student("Consta", "007", "11C"),
                Set.of(
                        new Subject("Math", 56),
                        new Subject("English", 87)
                ),
                new Student("Olga", "006", "11A"),
                        Set.of(
                                new Subject("English", 99),
                                new Subject("Math", 77)
                        )
        );
        College college = new College(students);
        assertThat(college.findByAccount("003"), is(Optional.empty()));
    }

    @Test
    public void whenAccountIsOptionalNotEmpty() {
        Map<Student, Set<Subject>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subject("Economic", 75),
                        new Subject("Sociology", 65)
                )
        );
        College college = new College(students);
        assertThat(college.findByAccount("000001").get().getGroup(), is("201-18-15"));
    }

    @Test
    public void whenSubjectIsOptionalEmptyWithNotFoundAccount() {
        Map<Student, Set<Subject>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subject("Economic", 75),
                        new Subject("Sociology", 65)
                )
        );
        College college = new College(students);
        assertThat(college.findBySubjectName("000010", "Sociology"), is(Optional.empty()));
    }

    @Test
    public void whenSubjectIsOptionalEmptyWithFoundAccount() {
        Map<Student, Set<Subject>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subject("Economic", 75),
                        new Subject("Sociology", 65)
                )
        );
        College college = new College(students);
        assertThat(college.findBySubjectName("000001", "Sociology"), is(Optional.empty()));
    }

    @Test
    public void whenSubjectIsOptionalNotEmpty() {
        Map<Student, Set<Subject>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subject("Economic", 75),
                        new Subject("Sociology", 65)
                )
        );
        College college = new College(students);
        assertThat(college.findBySubjectName("000002", "Sociology").get().getScore(), is(65));
    }
}
package ru.job4j.course.stream.attestation;

import java.util.List;

/**
 * 2. Аттестация.
 * Данный класс описывает ученика.
 */
public class Pupil {
    private String name;
    private List<Subject> subjects;

    public Pupil(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}

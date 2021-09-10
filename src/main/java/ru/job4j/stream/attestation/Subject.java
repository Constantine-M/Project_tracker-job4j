package ru.job4j.stream.attestation;

/**
 * 2. Аттестация.
 * Данный класс описывает школьный предмет
 * и аттестационный балл ученика.
 */
public class Subject {
    private String name;
    private int score;

    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

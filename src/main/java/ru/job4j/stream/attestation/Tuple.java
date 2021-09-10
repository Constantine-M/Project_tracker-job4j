package ru.job4j.stream.attestation;

import java.util.Objects;

/**
 * 2. Аттестация.
 * Данный класс описывает результаты
 * как учеников, так и предметов.
 * Например у ученика - это Иван,
 * который имеет 100 баллов.
 * Остальное здесь не имеет значения,
 * только имя/предмет и его балл.
 */
public class Tuple {
    private String name;
    private double score;

    public Tuple(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tuple tuple = (Tuple) o;
        return Double.compare(tuple.score, score) == 0
                && Objects.equals(name, tuple.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}

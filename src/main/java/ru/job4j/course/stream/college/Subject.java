package ru.job4j.course.stream.college;

import java.util.Objects;

/**
 * 6. Тестовое задание из модуля коллекции
 * Lite переделать на Stream API.
 *  * Данный класс описывает модель данных
 *  - изучаемый предмет, у которого есть
 *  имя и оценка по этому предмету.
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

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name)
                && Objects.equals(score, subject.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return "Subject{"
                + "name='" + name + '\''
                + ", score='" + score + '\''
                + '}';
    }
}

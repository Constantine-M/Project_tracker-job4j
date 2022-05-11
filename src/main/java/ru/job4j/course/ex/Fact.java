package ru.job4j.course.ex;

public class Fact {
    public static void main(String[] args) {
        System.out.println("Factorial value: " + calc(3));
    }

    public static int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N must be positive");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}

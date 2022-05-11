package ru.job4j.course.oop;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class TriangleTest {

    @Test
    public void area() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 4);
        Point c = new Point(4, 0);
        Triangle abc = new Triangle(a, b, c);
        double rsl = abc.area();
        assertThat(rsl, closeTo(8, 0.001));
    }
}
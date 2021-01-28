package ru.job4j.oop;

import static java.lang.Math.sqrt;

/**Этот класс будет работать с объектами Point.*/
public class Triangle {

    /**Создали поле класса Point, который уже имеет свои параметры.
     * Данное поле будет принадлежать объекту класса Triangle.
     * Если я верно понял, что здесь мы просто ссылаемся на объект класса Point.
     */
    private Point first;
    private Point second;
    private Point third;

    /**Создали конструктор класса Triangle.
     * Он описывает форму треугольника с помощью 3 точек, которые имеют координаты.
     * @param ap - первая точка. Объект класса Point.
     * @param bp - вторая точка. Объект класса Point.
     * @param cp - треться точка. Объект класса Point.
     */
    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    /**
     * С помощью данного метода найдем полуметриметр треугольника.
     * @param a - одна из сторон треугольника. Пусть будет аb.
     * @param b - одна из сторон треугольника. Пусть будет bc.
     * @param c - одна из сторон треугольника. Пусть будет ac.
     * @return значение полупериметра.
     */
    public double poluperimetr(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    /**Данный метод дает ответ на вопрос -
     * можно ли из переданных длин сторон построить треугольник?
     * Сумма 2 любых сторон всегда больше третьей.
     * Это должно применяться ко всем сочетаниям сторон.
     */
    public boolean exist(double ab, double ac, double bc) {
        return (ab + ac) > bc && (ab + bc) > ac && (ac + bc) > ab;
    }

    /**Данный метод вычисляет  площадь треугольника.
     * Отдельно создаем переменные, чтобы конечная формула смотрелась локоничнее.
     * @return площадь треугольника
     */
    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double bc = second.distance(third);
        double ac = first.distance(third);
        double p = poluperimetr(ab, bc, ac);
        if (this.exist(ab, bc, ac)) {
            rsl = sqrt(p * (p - ab) * (p - bc) * (p - ac));
        }
        return rsl;
    }
}

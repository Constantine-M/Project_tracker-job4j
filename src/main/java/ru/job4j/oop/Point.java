package ru.job4j.oop;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**Данный класс описывает точку в системе координат.*/
public class Point {

    /**Создали поле для объекта "точка".
     * Данное поле будет заполнено значением координаты (х) точки.
     * Оно будет принадлежать конкретному объекту.
     */
    private int x;

    /**Создали поле для объекта "точка".
     * Данное поле будет заполнено значением координаты (у) точки.
     * Оно будет принадлежать конкретному объекту.
     */
    private int y;

    /**Создал конструктор, который описывает класс Point.
     * Теперь у объекта (точка) имеются параметры - координаты.
     * @param first - координата х.
     * @param second - координата у.
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    /**
     * Данный метод вычисляет расстояние между точками.
     * @param that - это есть вторая точка с координатами х и у.
     * @return значения расстояния между точками.
     */
    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }
}

package ru.job4j.oop.updowncastparttwo;

public class PolyUsage2 {
    /**
     * Мы создали интерфейс Anima. Он объединяет все классы.
     * А потом мы создали объекты разных классов, при этом приводя
     * все эти объекты к общему для каждого из этих классов типу Anima (наш интерфейс).
     * И можем точно так же сложить это всё в массив объектов типа Anima.
     */
    public static void main(String[] args) {
        /**Приводим объекты разных классов к общему типу Anima (наш интерфейс).*/
        Anima cow = new Cow2();
        Anima goose = new Goose2();
        Anima dog = new Dog2();
        Anima guineaPig = new GuineaPig2();

        Anima[] animals = new Anima[] {cow, goose, dog, guineaPig};
        for (Anima anima : animals) {
            anima.sound();
        }
    }
}

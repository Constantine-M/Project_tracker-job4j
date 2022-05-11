package ru.job4j.course.oop.kolobok;

/**Создадим класс Story и создадим объекты нашей истории*/
public class BallStory {
    /**Здесь мы создали три объекта, а ниже
     * вызвали методы у объектов и передали в них другие объекты.
     */
    public static void main(String[] args) {
        Ball kolobok = new Ball();
        Hare hare = new Hare();
        Wolfling wolfling = new Wolfling();
        Fox fox = new Fox();
        kolobok.tryEat(kolobok);
        hare.tryEat(kolobok);
        wolfling.tryEat(kolobok);
        fox.tryEat(kolobok);
    }
}

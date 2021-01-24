package ru.job4j.oop;

/**Создадим класс Story и создадим объекты нашей истории*/
public class Story {
    /**Здесь мы создали три объекта, а ниже
     * вызвали методы у объектов и передали в них другие объекты.
     * Подобное программирование и есть ООП.
     * Мы работаем с объектами, которым можно описать процессы нашей программы.
     */
    public static void main(String[] args) {
    Pioneer petya = new Pioneer();
    Wolf wolf = new Wolf();
    Girl girl = new Girl();
    petya.kill(wolf);
    wolf.eat(girl);
    girl.help(petya);
    }
}

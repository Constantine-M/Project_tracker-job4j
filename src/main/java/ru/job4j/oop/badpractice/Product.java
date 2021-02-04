package ru.job4j.oop.badpractice;

/**Здесь мы покажем, что наследование - плохо.
 * Это один классов. Здесь мы опишем продукт и
 * методы взаимодействия, а именно здесь будет отображаться ценник.
 * final - это ключевое слово, позволяющее запретить наследование.
 */
public final class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int price() {
        return price - discount();
    }

    /**В данном методе отображается скидка на товар*/
    public int discount() {
        return 0;
    }

    public String label() {
        return name + " " + price();
    }
}

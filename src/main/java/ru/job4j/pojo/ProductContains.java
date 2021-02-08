package ru.job4j.pojo;

/**В этом примере мы сравниваем 2 объекта.
 * Для сравнения нужно использовать метод equals.
 */
public class ProductContains {
    public static void main(String[] args) {
        Product first = new Product("Milk", 100);
        Product second = new Product("Milk", 100);
        boolean eq = first.equals(second);
        System.out.println(eq);
    }
}

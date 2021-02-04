package ru.job4j.oop.badpractice;

/**Через неделю нам понадобились продукты со скидкой.
 * Создаем наследника.
 */
public final class LiquidationProduct {
    /**Создадим поле, в котором будет находиться объект Product.
     * Такой подход называется КОМПОЗИЦИЯ.
     */
    private Product product;

    /**Я так понял - раз мы тут всё переделали под композицию,
     * то и super() не нужен судя по всему.
     * Создал конструктор, который будет описывать
     * цену со скидкой. В качестве аргумента выступает переменная поля,
     * которая является объектом класса Product.
     * То есть мы ссылаемся на объект product класса Product.
     */
    public LiquidationProduct(String name, int price) {
        product = new Product(name, price);
    }

    /**Мы переопределили метод (от метода родительского класса)
     * и написали так, чтобы скидка составляла 90%.
     * @return 90% скидка.
     * P.S. А потом (когда прописали в классе Product - final)
     * метод discount будет считаться новым? Ведь он не унаследван получается..
     */
    public int discount() {
        return 90;
    }

    public String label() {
        return product.label();
    }
}
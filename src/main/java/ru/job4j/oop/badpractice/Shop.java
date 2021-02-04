package ru.job4j.oop.badpractice;

/**Тут мы покажем, что наследование имеет плюсы и минусы.*/
public class Shop {
    public static void main(String[] args) {
        Product product = of("Oil", 100);
        System.out.println(product.label());
    }

    /**Изменили логику немного.
     * Теперь у нас конкретные товары могут выводиться со скидкой.
     * @param name имя товара
     * @param price его цена
     * @return возвращает объект класса "продукт" с его именем и ценой
     * После отключения наследования в данном методе уже, получается,
     * не совсем корректно возвращать объект класса Product, т.к.
     * нам ведь нужен объект другого класса...
     */
    public static Product of(String name, int price) {
        if ("Oil".equals(name)) {
            return new LiquidationProduct(name, price);
        }
        return new Product(name, price);
    }
}

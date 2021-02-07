package ru.job4j.pojo;

public class Shop {
    /**Метод проверки на null.
     * @param products объекты (продукты) класса Product.
     * @return индекс первой пустой ячейки.
     */
    public static int indexOfNull(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                return i;
            }
        }
        return -1;
    }
    /**Создаим массив на 5 эл-ов и заполним 3.
     * Чтобы избежать лишних строк, будем сразу создавать объект
     * и записывать его в нужную нам ячейку.
     */
    public static void main(String[] args) {
        Product products[] = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        /**Проверим, что объект не равен null. Т.к. у нас массив не заполнен целиком.
         * Создали переменную product класса Product, чтобы в цикле чуть-чуть меньше писать.
         * Здесь выпадает ошибка NPE. Нужно ли её сейчас править?
         */
        for (int index = 0; index < products.length; index++) {
            Product product = products[index];
            if (product.getName() != null) {
                System.out.println(product.getName());
            }
        }
    }
}

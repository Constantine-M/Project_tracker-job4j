package ru.job4j.pojo;

public class ShopDrop {
    /**Этот метод должен сместить ячейки на одну позицию влево.
     * Метод принимает индекс ячейки, с которого нужно начинать смещение.
     * @param products продукт - переменная класса Product.
     * @param index индекс.
     * @return новый массив со смещенной ячейкой.
     */
    public static Product[] leftShift(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
            products[i] = products[i + 1];
        }
        products[products.length - 1] = null;
        return products;
    }

    public static void main(String[] args) {
        Product products[] = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (int i = 0; i < products.length; i++) {
            Product prod = products[i];
            System.out.println(prod.getName());
        }
        products[1] = null;
        System.out.println();
        /**Теперь в массиве у нас нет продукта Bread.
         * Появилась пустая ячейка среди заполненных.
         * Переместим ячейки вручную.
         */
        products[1] = products[2];
        products[2] = null;
        for (int i = 0; i < products.length; i++) {
            Product prod = products[i];
            if (prod != null) {
                System.out.println(prod.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}

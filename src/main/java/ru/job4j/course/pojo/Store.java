package ru.job4j.course.pojo;

public class Store {
    public static void main(String[] args) {
        Product milk = new Product("Milk", 10);
        Product bread = new Product("Bread", 4);
        Product egg = new Product("Egg", 19);

        /**
         * В массивах можно хранить как примитивные,
         * так и ссылочные типы данных.
         * То есть мы можем добавить в массив наши продукты.
         */
        Product[] prods = new Product[3];

        /**
         * Сначала мы объявляем массив на 3 элемента.
         * Далее через указание номера ячейки мы
         * присваиваем в ячейку значение переменной Product.
         */
        prods[0] = milk;
        prods[1] = bread;
        prods[2] = egg;

        /**
         * Изначально не понял, для создавать еще один объект,
         * поэтому для проверки закомментировал строку
         * Product pr = prods[index]. К счастью все работает и без нее.
         */
        for (int index = 0; index < prods.length; index++) {
            /*Product pr = prods[index];*/
            System.out.println(prods[index].getName() + " - " + prods[index].getCount());
        }
        System.out.println("Replace milk to oil.");
        Product oil = new Product("Oil", 11);
        prods[0] = oil;

        /**
         * Мы получаем ячейку массива, далее записываем ее в переменную Product pr
         * (которую я закомментировал).
         * А после этого выводим имя и количество продукта на консоль через аксессоры.
         */
        for (int index = 0; index < prods.length; index++) {
            Product pr = prods[index];
            System.out.println(pr.getName() + " - " + pr.getCount());
        }

        /**
         * В цикле мы указываем именно pr.getCount(), так как
         * именно этот метод выдает нам значение кол-ва продуктов.
         * В методе main нет в явном виде указания на кол-во.
         * Мы указываем значение count для объекта, которое описано в другом классе.
         */
        System.out.println("Shown only product.count > 10");
        for (int index = 0; index < prods.length; index++) {
            Product pr = prods[index];
            if (pr.getCount() > 10) {
                System.out.println(pr.getName() + " - " + pr.getCount());
            }
        }
    }
}

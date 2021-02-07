package ru.job4j.pojo;

public class Product {
    private String name;
    private int count;

    /**Создадим конструтор, который будет описывать объект
     * класса Product.
     * @param name наименование
     * @param count кол-во
     */
    public Product(String name, int count) {
        this.name = name;
        this.count = count;
    }

    /**Сгенерируем аксессоры*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}

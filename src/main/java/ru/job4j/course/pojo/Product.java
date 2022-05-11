package ru.job4j.course.pojo;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return count == product.count
                && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count);
    }
}

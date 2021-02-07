package ru.job4j.pojo;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

public class ShopDropTest {

    @Test
    public void whenDropFirst() {
        Product product[] = new Product[2];
        product[0] = new Product("Milk", 10);
        product[1] = new Product("Bread", 4);
        Product prod[] = ShopDrop.leftShift(product, 0);
        assertThat(prod[0].getName(), is("Bread"));
        assertThat(prod[1].getName(), is(nullValue()));
    }

    @Test
    public void whenDropLast() {
        Product product[] = new Product[2];
        product[0] = new Product("Milk", 10);
        product[1] = new Product("Bread", 4);
        Product prod[] = ShopDrop.leftShift(product, 1);
        assertThat(prod[0].getName(), is("Milk"));
        assertThat(prod[1].getName(), is(nullValue()));
    }
}
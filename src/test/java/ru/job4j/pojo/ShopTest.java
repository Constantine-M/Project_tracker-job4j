package ru.job4j.pojo;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ShopTest {

    @Test
    public void whenLastNull() {
        Product[] product = new Product[5];
        product[0] = new Product("Milk", 10);
        product[1] = new Product("Bread", 4);
        product[2] = new Product("Egg", 19);
        int rsl = Shop.indexOfNull(product);
        assertThat(rsl, is(3));
    }

    @Test
    public void whenFirstNull() {
        Product[] product = new Product[5];
        product[1] = new Product("Milk", 10);
        product[2] = new Product("Bread", 4);
        product[3] = new Product("Egg", 19);
        int rsl = Shop.indexOfNull(product);
        assertThat(rsl, is(0));
    }

    @Test
    public void whenHasNotNull() {
        Product[] product = new Product[5];
        product[0] = new Product("Milk", 10);
        product[1] = new Product("Bread", 4);
        product[2] = new Product("Egg", 19);
        product[3] = new Product("Oil", 11);
        product[4] = new Product("Grechiha posevnaya", 1);
        int rsl = Shop.indexOfNull(product);
        assertThat(rsl, is(-1));
    }
}
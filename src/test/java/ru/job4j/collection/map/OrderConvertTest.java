package ru.job4j.collection.map;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class OrderConvertTest {

    /**
     * Изначально хотел сравнить мапы - ту что получилась с той, что ожидалась,
     * но вышло бы больше строк. Поэтому лучше все же как в задаче -
     * сравнить конкретные элементы в коллекции.
     */
    @Test
    public void process() {
        List<Order> orders = Arrays.asList(
                new Order("1", "cheese"),
                new Order("2", "eggs"),
                new Order("3", "milk")
        );
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3"), is(new Order("3","milk")));
    }

    /**
     * Отлично. Оказывается все же и так можно, если оно, конечно,
     * уместно в данной задаче.
     */
    @Test
    public void whenCompareMaps() {
        List<Order> orders = Arrays.asList(
                new Order("1", "cheese"),
                new Order("2", "eggs"),
                new Order("3", "milk")
        );
        HashMap<String, Order> map = OrderConvert.process(orders);
        HashMap<String, Order> expected = OrderConvert.process(orders);
        expected.put("1", new Order("1", "cheese"));
        expected.put("2", new Order("2", "eggs"));
        expected.put("3", new Order("3", "milk"));
        assertThat(map, is(expected));
    }
}
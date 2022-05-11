package ru.job4j.course.collection.search;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PriorityQueueTest {

    @Test
    public void whenUrgentIsHighPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("Low", 5));
        queue.put(new Task("Urgent", 1));
        queue.put(new Task("Medium", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("Urgent"));
    }
}
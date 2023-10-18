package ru.job4j.tracker;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Данный класс демонстрирует
 * возможности фреймворка Mockito
 * на примере тестирования
 * консольного вывода.
 */
public class FindByIDActionTest {

    @Test
    public void whenFindItem() {
        Store tracker = new MemTracker();
        Output out = new StubOutput();
        UserAction findAction = new FindByIDAction(out);
        tracker.add(new Item("foundItem"));

        Input input = mock(Input.class);

        when(input.askInt(any())).thenReturn(1);

        findAction.execute(input, tracker);

        String ls = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(tracker.findById(1).toString() + ls);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("foundItem");
    }
}
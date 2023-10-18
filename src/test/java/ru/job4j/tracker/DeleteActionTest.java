package ru.job4j.tracker;

import org.junit.Test;

import java.util.Collections;

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
public class DeleteActionTest {

    @Test
    public void whenDeleteSuccessfully() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Removed item"));
        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        del.execute(input, tracker);

        String ls = System.lineSeparator();
        assertThat(tracker.findAll()).isEqualTo(Collections.emptyList());
        assertThat(out.toString()).isEqualTo(
                "==== Removal process ===="
                + ls
                + "==== Record removed successfully ===="
                + ls);
    }

    @Test
    public void whenItemNotFound() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Removed item"));
        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(2);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "==== Removal process ===="
                        + ln
                        + "==== Record ID not found ===="
                        + ln);
    }
}
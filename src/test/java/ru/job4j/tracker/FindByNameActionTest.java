package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.action.FindByNameAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.io.StubOutput;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;

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
public class FindByNameActionTest {

    @Test
    public void execute() {
        Store tracker = new MemTracker();
        Output out = new StubOutput();
        UserAction findByName = new FindByNameAction(out);
        tracker.add(new Item("myNameIs"));

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("myNameIs");

        findByName.execute(input, tracker);

        String ls = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(tracker
                        .findByName("myNameIs")
                        .get(0)
                        .toString()
                        + ls);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("myNameIs");
    }
}
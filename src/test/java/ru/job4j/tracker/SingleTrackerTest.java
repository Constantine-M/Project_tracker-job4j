package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SingleTrackerTest {

    /**
     * Насколько я понял - метод возвращает объект.
     * При этом он возвращает не новый объект, а один и тот же.
     * Ссылки на объект должны быть одинаковыми.
     * Это можно проверить с помощью assertSame.
     */
    @Test
    public void whenSingletonIsSetUp() {
        SingleTracker first = SingleTracker.getInstance();
        SingleTracker second = SingleTracker.getInstance();
        Assert.assertSame(first, second);

    }
}
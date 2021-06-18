package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidateInputTest {

    /**
     * Эмулируем ввод. Сначала неверный вариант, потом верный.
     * ...new String[] {"one", "1"}
     * Создаем объект класса ValidateInput, чтобы получить доступ
     * к методу, который проверяем собственно.
     * ...ValidateInput input = new ValidateInput(out, in)
     * int selected - это как раз тот самый результат работы
     * метода askInt в классе ValidateInput.
     * То есть ввод данных будет сопровожден стройкой "Enter menu:".
     * Этот текст не должен тебя путать.
     * Он может быть любым.
     * Мы проверяем метод askInt, в результате работы которого
     * метод из 2 вариантов ("one", "1")
     * должен выбрать правильный - 1.
     */
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    /**Не понимаю, чем он отличается от первого теста.*/
    @Test
    public void whenCorrectInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenCorrectInputManyTimes() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int first = input.askInt("Enter menu:");
        int second = input.askInt("Enter menu:");
        int[] result = {first, second};
        int[] expected = {0, 1};
        assertThat(result, is(expected));
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }
}
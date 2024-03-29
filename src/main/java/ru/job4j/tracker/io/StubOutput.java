package ru.job4j.tracker.io;

/**
 * Данный класс является заглушкой.
 *
 * Он, как и {@link StubInput},
 * будет использоваться для тестов.
 */
public class StubOutput implements Output {

    private final StringBuilder buffer = new StringBuilder();

    @Override
    public void println(Object obj) {
        if (obj != null) {
            buffer.append(obj.toString());
        } else {
            buffer.append("null");
        }
        buffer.append(System.lineSeparator());
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}

package ru.job4j.inheritance;

public class TextReport {

    /**LineSeparator () — это встроенный метод в Java,
     * который возвращает системно-зависимую строку разделителя строк.
     * В общем строки переносит (если очень грубо).
     */
    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }
}

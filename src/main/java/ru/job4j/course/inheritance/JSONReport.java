package ru.job4j.course.inheritance;

public class JSONReport extends TextReport {
    /**Переопределим метод generate, который мы унаследовали
     * от родительского класса TextReport.
     * Аннотация @Override используется только для методов.
     * Она позволяется подтвердить работу механизма переопределения.
     */
    @Override
    public String generate(String name, String body) {
        return "{" + System.lineSeparator() + name + " : name" + "," + System.lineSeparator()
                 + body + " : body" + System.lineSeparator() + "}";
    }
}

package ru.job4j.course.inheritance;

/**Теперь нам нужен отчет в формате html
 * Создали наследника от класса TextReport.
 */
public class HtmlReport extends TextReport {
    /**Переопределим метод generate, который мы унаследовали
     * от родительского класса TextReport.
     * Аннотация @Override используется только для методов.
     * Она позволяется подтвердить работу механизма переопределения.
     */
    @Override
    public String generate(String name, String body) {
        return "<h1>" + name + "</h1>"
               +  "<br/>"
               + "<span>" + body + "</span>";
    }
}

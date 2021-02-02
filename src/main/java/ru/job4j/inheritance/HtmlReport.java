package ru.job4j.inheritance;

/**Теперь нам нужен отчет в формате html
 * Создали наследника от класса TextReport.
 */
public class HtmlReport extends TextReport {

    /**Переопределим метод generate, который мы унаследовали
     * от родительского класса TextReport.
     */
    public String generate(String name, String body) {
        return "<h1>" + name + "</h1>" +
                "<br/>" +
                "<span>" + body + "</span>";
    }
}

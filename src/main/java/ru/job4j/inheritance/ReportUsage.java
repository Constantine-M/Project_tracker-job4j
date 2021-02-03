package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        HtmlReport rept = new HtmlReport();
        String words = rept.generate("Report's name", "Report's body");
        System.out.println(words);
        JSONReport reply = new JSONReport();
        String doklad = reply.generate("name", "body");
        System.out.println(doklad);
    }
}

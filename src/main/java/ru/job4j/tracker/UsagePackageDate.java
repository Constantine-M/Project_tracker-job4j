package ru.job4j.tracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UsagePackageDate {

    /**С помощью методов LocalDate/LocalTime/LocalDateTime,
     * выведем ткущую дату/время на консоль.
     * Чтобы получить текущие дату, время или и дату и время,
     * во всех трех классах определен статический метод now(),
     * который возвращает объект соответствующего класса
     */
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Текушая дата: " + currentDate);
        LocalTime currentTime = LocalTime.now();
        System.out.println("Текущее время: " + currentTime);
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Текущие дата и время до форматирования: " + currentDateTime);
        /**Отформатируем вывод таким образом,
         * чтобы вывод в консоль не содержал символ "T", а также наносекунды.
         */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dateTime = currentDateTime.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + dateTime);
    }
}

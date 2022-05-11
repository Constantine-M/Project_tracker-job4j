package ru.job4j.tracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UsagePackageDate {

    /**
     * Данный класс описывает работу
     * {@link LocalDate},
     * {@link LocalTime},
     * {@link LocalDateTime}.
     *
     * С помощью методов этих классов,
     * выведем ткущую дату/время на консоль.
     *
     * Чтобы получить текущие дату,
     * время или дату и время, во всех
     * трех классах определен статический
     * метод now(), который возвращает
     * объект соответствующего класса.
     *
     * Можно отформатировать вывод
     * таким образом, чтобы вывод в
     * консоль не содержал символ
     * "T", а также наносекунды.
     */
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Текушая дата: " + currentDate);
        LocalTime currentTime = LocalTime.now();
        System.out.println("Текущее время: " + currentTime);
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Текущие дата и время до форматирования: " + currentDateTime);
        System.out.println("WITHOUT nanoseconds");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dateTime = currentDateTime.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + dateTime);
    }
}

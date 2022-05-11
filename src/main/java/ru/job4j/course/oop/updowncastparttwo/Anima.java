package ru.job4j.course.oop.updowncastparttwo;

/**
 * Создали интерфейс, в который мы вынесем метод, который будет доступен всем животным,
 * однако для каждого он будет иметь собственную реализацию.
 * Все классы продублирую с цифрой 2.
 */
public interface Anima {
    public void sound();
}

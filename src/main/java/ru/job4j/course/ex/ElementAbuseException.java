package ru.job4j.course.ex;

/**
 * Данное исключение будет возникать, когда найденное слово попадает в запрещенный список.
 */
public class ElementAbuseException extends ElementNotFoundException {
    public ElementAbuseException(String message) {
        super(message);
    }
}

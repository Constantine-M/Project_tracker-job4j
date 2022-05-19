package ru.job4j.tracker;

/**
 * Данный класс расширяет возможности
 * класса {@link ConsoleInput}, потому что...
 *
 * В методе {@link ConsoleInput#askInt}
 * предусмотрены НЕ ВСЕ действия пользователя.
 *
 * Давайте добавим в него нужное поведение
 * за счет механизма переопределения (override).
 *
 * Данный класс предостерегает от
 * некорректного ввода. В нашем случае от
 * ввода вместо числа - текста.
 * Далее мы избавляемся от зависимости
 * от класса {@link ConsoleInput}.
 *
 * Привязываем класс к интерфейсу Input.
 */
public class ValidateInput implements Input {

    private final Output out;
    private final Input in;

    /**
     * Избавились от связи с {@link ConsoleInput}.
     *
     * Теперь мы можем в это поле
     * передать класс {@link ConsoleInput}
     * или {@link StubInput}, и к их
     * поведению добавить поведение валидации.
     */
    public ValidateInput(Output out, Input in) {
        this.out = out;
        this.in = in;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    /**
     * С консоли вводим значение, а затем
     * его приводим к числу с помощью
     * метода {@link Integer#parseInt(String)}.
     *
     * Данный метод может бросить
     * исключение класса {@link NumberFormatException}.
     *
     * Поэтому добавили в наш метод проверку,
     * что введенная строка содержит только числа.
     *
     * Я ЗАКОММЕНТИРОВАЛ КОД НИЖЕ, ПОТОМУ ЧТО
     * В нашем случае мы сначала вводим
     * значение с консоли, потом проверяем его,
     * что оно не содержит буквенных
     * символов и потом передаем его
     * в метод {@link Integer#parseInt}, который
     * все равно дополнительно выполнит эту
     * проверку - т.е. мы валидацию
     * введенного параметра выполним два раза.
     *
     * Именно поэтому стоит отдавать
     * предпочтение обработке исключения.

     String rsl = in.askStr(question);
     if (!isNumber(rsl)) {
     out.println("Please enter validate data again.");
     continue;
     }
     value = Integer.parseInt(rsl);
     invalid = false;

     * @param question значение с консоли.
     * @return проверенное значение.
     */
    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }

    /**
     * Данный метод проверяет, что в
     * строке прописаны только цифры.
     *
     * @param value текст, которй
     *              вводит пользователь.
     * @return число или текст (правда или ложь).
     */
    public boolean isNumber(String value) {
        boolean rsl = true;
        char[] check = value.toCharArray();
        for (char num : check) {
            if (num < 48 || num > 57) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}

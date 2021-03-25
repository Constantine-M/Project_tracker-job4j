package ru.job4j.tracker;

/**
 * Данный класс расширяет возможности класса ConsoleInput, потому что...
 * В методе ConsoleInput.askInt предусмотрены НЕ ВСЕ действия пользователя.
 * Давайте добавим в него нужное поведение за счет механизма переопределения (override).
 * Данный класс предостерегает от некорректного ввода. В нашем случае от
 * ввода вместо числа - текста.
 * Далее мы избавляемся от зависимости от класса ConsoleInput.
 * Привязывает класс к интерфейсу Input.
 */
public class ValidateInput implements Input {
    private final Output out;
    private final Input in;

    /**
     * Избавились от связи с классом ConsoleInput.
     * Теперь мы можем в это поле передать класс ConsoleInput
     * или StubInput, и к их поведению добавить поведение валидации
     */
    public ValidateInput(Output out, Input in) {
        this.out = out;
        this.in = in;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            String rsl = in.askStr(question);
            if (!isNumber(rsl)) {
                out.println("Please enter validate data again.");
                continue;
            }
        } while (invalid);
        return value;
    }

    /**
     * Данный метод проверяет, что в строке прописаны только цифры.
     * @param value текст, которй вводит пользователь
     * @return число или текст (правда или ложь)
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

package ru.job4j.course.ex;

public class FindEl {
    /**
     * Unhandled exception - необработанное исключение.
     * Если мы используем в коде классы не имеющие в иерархии наследования
     * java.langRuntimeException, то их нужно обрабатывать.
     * Первый способ - это объявления исключений в сигнатуре метода
     * с помощью throws.
     * В этом случае мы передаем ответственность за исключение коду,
     * который будет использовать наш метод.
     */
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (key.equals(value[index])) {
                rsl = index;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not found.");
        }
        return rsl;
    }

    /**
     * Второй вариант - это использование конструкции try-catch.
     * Блок try содержит операторы, которые мы хотим выполнить.
     * Блок catch содержит объявление исключение.
     * Если операторы в блоке try вызовут исключение UserInputException,
     * то программа перейдет к выполнению блока catch.
     */
    public static void main(String[] args) {
        String[] list = {"Consta", "Petr", "Stas", "Zack"};
        try {
            System.out.println(indexOf(list, "Mezenin"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}

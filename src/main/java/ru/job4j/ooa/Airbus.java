package ru.job4j.ooa;

public final class Airbus extends Aircraft {
    /**
     * Модификатор static делает переменную доступной без
     * загрузки экземпляра ее определяющего класса.
     */
    public static final int COUNT_ENGINE = 2;

    /**
     * Ничего умнее к сожалению не придумалось.
     * Пробовал перегружать конструктор - тоже не то.
     * Пробовал манипуляции с константой вроде COUNT_ENGINE += 2 или
     * COUNT_ENGINE += COUNT_ENGINE - тоже глупо вышло.
     */
    private static int engines = 4;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        if (name == "A380") {
            System.out.println("Количество двигателей равно: " + engines);
        } else {
            System.out.println("Количество двигателей равно: " + COUNT_ENGINE);
        }
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}

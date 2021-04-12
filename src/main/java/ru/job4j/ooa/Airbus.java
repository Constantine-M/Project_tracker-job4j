package ru.job4j.ooa;

public final class Airbus extends Aircraft {
    /**
     * Модификатор static делает переменную доступной без
     * загрузки экземпляра ее определяющего класса.
     */
    public static final int COUNT_ENGINE = 2;

    /**
     * Эту переменную НЕ нужно делать статической, иначе она будет общей для всех Airbus.
     */
    private int engines;

    private String name;

    public Airbus(String name) {
        this.name = name;
        if (name.equals("A380")) {
            engines = 4;
        } else {
            engines = COUNT_ENGINE;
        }
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
        System.out.println("Кол-во двигателей: " + engines);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}

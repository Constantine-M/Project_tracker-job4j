package ru.job4j.course.ooa;

public final class Airbus extends Aircraft {
    /**
     * Модификатор static делает переменную доступной без
     * загрузки экземпляра ее определяющего класса.
     */
    public static final int COUNT_ENGINE = 2;

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

    /**
     * Переменную engines сделал локальной. Логично, т.к. у нас ведь есть константа
     * и условие, что 4 двигателя только у 1 самолета, а у остальных по 2.
     * Еще одна перменная поля явно была лишней, но до меня не дошло.
     */
    public void printCountEngine() {
        int engines = 0;
        if (name.equals("A380")) {
            engines = 4;
        } else {
            engines = COUNT_ENGINE;
        }
        System.out.println("Кол-во двигателей: " + engines);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}

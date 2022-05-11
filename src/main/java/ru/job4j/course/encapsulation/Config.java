package ru.job4j.course.encapsulation;

public class Config {
    /**Здесь был default - изменил на private.*/
    private String name;
    /**Здесь был модификатор protected. Поправил на private.*/
    private int position;

    /**Здесь был модификатор public. Поправил на private.
     * В нашем курсе для всех полей используется private.*/
    private String[] properties;

    public Config(String name) {
        this.name = name;
    }

    /**В данном методе был модификатор default. Исправил на public.*/
    public void print() {
        System.out.println(position);
    }

    /**В данном методе был модификатор protected. Исправил на public.*/
    public String getProperty(String key) {
        return search(key);
    }

    private String search(String key) {
        return key;
    }
}

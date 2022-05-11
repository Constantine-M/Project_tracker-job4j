package ru.job4j.course.pojo;

public class Book {
    private String name;
    private int sheets;

    /**Создал конструктор, который описывает объект класса Book.
     * @param name имя книги
     * @param sheets кол-во страниц в книге
     */
    public Book(String name, int sheets) {
        this.name = name;
        this.sheets = sheets;
    }

    /**Сгенерировал аксессоры для класса Book*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSheets() {
        return sheets;
    }

    public void setSheets(int sheets) {
        this.sheets = sheets;
    }
}

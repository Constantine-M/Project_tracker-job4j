package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book wizards = new Book("Harry Potter", 305);
        Book stars = new Book("Darth Plagueis", 420);
        Book lore = new Book("Rise of the Lich King", 250);
        Book java = new Book("Clean code", 1500);
        Book[] books = new Book[4];
        books[0] = wizards;
        books[1] = stars;
        books[2] = lore;
        books[3] = java;
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getSheets());
        }
        System.out.println("Swap first line and last");
        Book temp = null;
        temp = books[0];
        books[0] = java;
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getSheets());
        }
        System.out.println("Display book - Clean code");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if (bk.getName().equals("Clean code")) {
                System.out.println(bk.getName() + " - " + bk.getSheets());
            }
        }
    }
}

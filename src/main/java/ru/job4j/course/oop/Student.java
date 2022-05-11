package ru.job4j.course.oop;

public class Student {
    /**
     * Чтобы научить студента играть, создадим метод.
     * Он должен находиться внутри тела класса.
     * А если хочется, чтобы он пел что-то конкретное,
     * то используем переменную (до этого скобки были пустые).
     */
    public void music(String lyrics) {
        System.out.println("I can sing a song: " + lyrics);
    }

    /**А теперь научим студента петь.
     * Таким же образом напишем метод внутри тела класса.
     */
    public void song() {
        System.out.println("I believe I can fly");
    }

    /**
     * Чтобы вызвать метод, нужно обратиться к переменной
     * petya объекта класса Student.
     * petya - это и есть объект. Но к объекту нужно обращаться
     * так же как и везде - через переменную.
     * Метод music имеет теперь входящий параметр (переменную lyrics типа String).
     * При вызове метода нужно проинициализировать этот параметр
     * (параметр типа String - название может быть другим).
     * Иначе код не скомпилируется.
     */
    public static void main(String[] args) {
        Student petya = new Student();
        String song = "I believe, I can fly";
        petya.music(song);
    }
}

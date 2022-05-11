package ru.job4j.course.oop;

public class DummyDic {
    /**Создали метод, который возвращает переменную типа String*/
    public String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }

    /**Теперь объект dictionary класса DummyDic обращается к методу engToRus.
     * Метод возвращает словосочетание "Неизвестное слово" и то что мы введем.
     * А потом нам нужно это вывести в консоль с помощью sout.
     */
    public static void main(String[] args) {
        DummyDic dictionary = new DummyDic();
        String unknown = dictionary.engToRus("Sireneven'kii refrezherator");
        System.out.println(unknown);
    }
}
